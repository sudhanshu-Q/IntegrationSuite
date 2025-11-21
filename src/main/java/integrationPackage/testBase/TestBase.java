package integrationPackage.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import integrationPackage.utils.CreateLogger;
import integrationPackage.utils.CustomisedAction;
import integrationPackage.utils.ExtentFactory;
import integrationPackage.utils.ReadProperties;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase extends CustomisedAction {

    BrowserFactory browserFactory = new BrowserFactory();

    @BeforeMethod
    public void launchApplication() throws Exception {
        String browser = ReadProperties.getProperties("browser");
        //Open browser
        DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(browser));
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // DriverFactory.getInstance().getDriver().navigate().to(url);

    }

    @AfterMethod
    public void tearDown() {
        //CLose browser
        DriverFactory.getInstance().closeBrowser();
        CreateLogger.endTestCase(new Throwable().getStackTrace()[0].getMethodName());
    }

}