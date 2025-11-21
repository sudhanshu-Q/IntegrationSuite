package integrationPackage.utils;


import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;

/*
 * @Author: Sudhanshu
 * Action items at one place
 */
public class CustomisedAction {

    public void sendkeys_CustomMethod(WebElement element, String sendText){
        try {
            element.sendKeys(sendText);
            CreateLogger.info("Sending text to :" + element.getAccessibleName()+ "Text to be sent :" + sendText);
        } catch (Exception e) {
           // ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Error in sending text :" + sendText+e.getMessage());
        }
    }

    public void click_CustomMethod(WebElement element){
        try{
            element.click();
            CreateLogger.info("Clicked on element :"+ element.getText() +" Successfully!");
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Clicked on element : " +element);
        } catch (Exception e) {
//            CreateLogger.error("Error in clicking on element : " + element+" : "+e.getMessage());
//            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Error while clicking on element : " +e.getMessage());
        }
    }

}



