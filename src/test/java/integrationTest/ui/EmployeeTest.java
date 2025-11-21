package integrationTest.ui;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import integrationPackage.pages.EmployeePageObjects;
import integrationPackage.testBase.DriverFactory;
import integrationPackage.testBase.TestBase;
import integrationPackage.utils.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.HashMap;

public class EmployeeTest extends TestBase {

    EmployeePageObjects employeePageObjects=new EmployeePageObjects();
    ExcelOperations excel = new ExcelOperations("Usercreate");

//    @Test
//    public void loginToEmployeeTest() throws SQLException, ClassNotFoundException {
//        CreateLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
//        DriverFactory.getInstance().getDriver().navigate().to(ReadProperties.getProperties("URL_EMPLOYEE"));
//        employeePageObjects.enterEmployeeDetails("sdssdsa","dsadad");
//      //  CreateLogger.info(dbUtilities.getSqlResultInMap("SELECT * FROM ENQUIRY_DETAILS "));
//        CreateLogger.endTestCase(new Throwable().getStackTrace()[0].getMethodName());
//
//    }

    @Test(dataProvider = "taskCreationData")
    public void loginToEmployeeTest2(Object obj1) throws SQLException, ClassNotFoundException {
        ExcelOperations excelOperations=new ExcelOperations("Usercreate");
        int rowNum=excelOperations.getRowCount();
        System.out.println("get number of rows"+rowNum);
        HashMap<String, String> testData = (HashMap<String, String>) obj1;
        CreateLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
        DriverFactory.getInstance().getDriver().navigate().to(ReadProperties.getProperties("URL_EMPLOYEE"));
        employeePageObjects.enterEmployeeDetails(testData.get("username"),testData.get("password"));
        //  CreateLogger.info(dbUtilities.getSqlResultInMap("SELECT * FROM ENQUIRY_DETAILS "));
        CreateLogger.endTestCase(new Throwable().getStackTrace()[0].getMethodName());

    }

    //Dataprovider method --> return object array
    @DataProvider(name = "taskCreationData")
    public Object[][] testDataSupplier() throws Exception {
        Object[][] obj = new Object[excel.getRowCount()][1];
        for (int i = 1; i <= excel.getRowCount(); i++) {
            HashMap<String, String> testData = excel.getTestDataInMap(i);
            obj[i-1][0] = testData;
        }
        return obj;

    }
}
