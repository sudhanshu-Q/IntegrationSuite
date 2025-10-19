package integrationPackage.pages;

import integrationPackage.testBase.DriverFactory;
import integrationPackage.testBase.TestBase;
import org.openqa.selenium.By;

public class EmployeePageObjects extends TestBase {

    By USERNAME = By.xpath("//input[@placeholder='Username']");
    By EMAIL = By.xpath("//input[@placeholder='Email']");
    By SUBMIT_BTN = By.xpath("//button[@type='submit']");

    public void enterEmployeeDetails(String username,String password){
        sendkeys_CustomMethod(DriverFactory.getInstance().getDriver().findElement(USERNAME),username);
        sendkeys_CustomMethod(DriverFactory.getInstance().getDriver().findElement(EMAIL),password);
        click_CustomMethod(DriverFactory.getInstance().getDriver().findElement(SUBMIT_BTN));
    }
}
