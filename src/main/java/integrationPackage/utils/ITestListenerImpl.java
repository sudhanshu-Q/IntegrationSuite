package integrationPackage.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import integrationPackage.testBase.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ITestListenerImpl implements ITestListener {
    //JiraOperations jiraOps = new JiraOperations();
    static ExtentReports report;
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        CreateLogger.info("ITestListener Implementation : "+result.getMethod().getMethodName());
        //before each test case
        test = report.createTest(result.getMethod().getMethodName());
        ExtentFactory.getInstance().setExtent(test);
    }

    public void onTestSuccess(ITestResult result) {
        CreateLogger.info("ITestListener Implementation : "+result.getMethod().getMethodName());
        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestFailure(ITestResult result) {
        CreateLogger.info("ITestListener Implementation : "+result.getMethod().getMethodName());
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");
        ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
        CreateLogger.error("ITestListener Implementation Error : "+result.getMethod().getMethodName());
        //add screenshot for failed test.
        File src = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String screenshotPath = System.getProperty("user.dir") +
                "/Screenshots/" + actualDate + "-"+result.getMethod().getMethodName()+".jpeg";
        File dest = new File(screenshotPath);
        CreateLogger.info("ITestListenerImpl File path for screenshots: "+screenshotPath);
        try {
            FileUtils.copyFile(src, dest);
            CreateLogger.info("Copying Screenshot file from SRC to DEST");
        } catch (IOException e) {
            e.printStackTrace();
            CreateLogger.error("Error in Copy file from SRC to DEST : "+e.getMessage());
        }
        try {
            ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath, "Test case failure screenshot");
            ExtentFactory.getInstance().removeExtentObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ///////JIRA defect creation part
//        String automaticJIRAcreation = PropertiesOperations.getPropertyValueByKey("automatic_Issue_Creation_In_JIRA");
//        if(automaticJIRAcreation.trim().equalsIgnoreCase("ON")) {
//            String issueS = "Automation Test Failed - "+result.getMethod().getMethodName();
//            String issueD = "Test Data to be passed here.";
//            String issueNumber = null;
//            try {
//                issueNumber = jiraOps.createJiraIssue("QDPM", issueS, issueD, "10000", "5", "QDPM", "SIT", "5f782c4b95fe8e0069705791");
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//            try {
//                jiraOps.addAttachmentToJiraIssue(issueNumber, screenshotPath);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

    //}

    public void onTestSkipped(ITestResult result) {
        CreateLogger.info("ITestListener Implementation : "+result.getMethod().getMethodName());
        ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
        ExtentFactory.getInstance().removeExtentObject();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        CreateLogger.info("ITestListener Implementation : "+result.getMethod().getMethodName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        CreateLogger.info("ITestListener Implementation : "+result.getMethod().getMethodName());
    }

    public void onStart(ITestContext context) {
        CreateLogger.info("ITestListener Implementation : "+context.getName());
        try {
            report = ExtentReportNG.setupExtentReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        CreateLogger.info("ITestListener Implementation : "+context.getName());
        //close extent
        report.flush();

    }

}
