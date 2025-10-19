package integrationPackage.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportNG {

    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws Exception {
        CreateLogger.info("Initialising Setup for Extent Report ");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);
        CreateLogger.info("Initialising Setup for Extent Report : " + actualDate);
        String reportPath = System.getProperty("user.dir")+
                "/Reports/ExecutionReport_"+actualDate+".html";
        CreateLogger.info("Creating Report path for Extent Report : " + reportPath);
        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("Automation SUite");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("Automation Test Run");
        CreateLogger.info("Setup Extent Report Configurations ");
        extent.setSystemInfo("Executed on Environment: ", ReadProperties.getProperties("URL_EMPLOYEE"));
        extent.setSystemInfo("Executed on Browser: ", ReadProperties.getProperties("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));
        CreateLogger.info("Setting System info in Extent Report :" + "Browser : " + ReadProperties.getProperties("browser"));
        return extent;
    }
}
