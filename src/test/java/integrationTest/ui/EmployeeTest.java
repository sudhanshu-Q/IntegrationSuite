package integrationTest.ui;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import integrationPackage.pages.EmployeePageObjects;
import integrationPackage.testBase.DriverFactory;
import integrationPackage.testBase.TestBase;
import integrationPackage.utils.CreateLogger;
import integrationPackage.utils.CustomisedAction;
import integrationPackage.utils.ExtentFactory;
import integrationPackage.utils.ReadProperties;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EmployeeTest extends TestBase {

    EmployeePageObjects employeePageObjects=new EmployeePageObjects();

    @Test
    public void loginToEmployeeTest(){
        CreateLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        DriverFactory.getInstance().getDriver().navigate().to(ReadProperties.getProperties("URL_EMPLOYEE"));
        employeePageObjects.enterEmployeeDetails("sdssdsa","dsadad");
        CreateLogger.endTestCase(new Throwable().getStackTrace()[0].getMethodName());
    }

//    @Test
//    public void employeeTest(){
//        DriverFactory.getInstance().getDriver().navigate().to(ReadProperties.getProperties("URL_EMPLOYEE"));
//        CreateLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
//        String getBrowserDetails=ReadProperties.getProperties("browser");
//        CustomisedAction customisedAction=new CustomisedAction();
//        WebElement ele = null;
//        customisedAction.sendkeys_CustomMethod(ele,getBrowserDetails);
//        CreateLogger.endTestCase(new Throwable().getStackTrace()[0].getMethodName());
//
//    }
}
