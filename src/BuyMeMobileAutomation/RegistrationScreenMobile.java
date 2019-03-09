package BuyMeMobileAutomation;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class RegistrationScreenMobile {
//    private static WebElement notRegistered;
//    private static WebElement elementFirstName;
//    private static WebElement elementEmail;
//    private static List<WebElement> elementPass;
//    private static WebElement elementIAgree;
//    private static WebElement submit;

    public void registerWithEmail(AndroidDriver<MobileElement> driver,WebDriverWait wait,String Email)throws Exception{
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys(Email);
        driver.findElement(By.id("continueButton")).click();
        WebElement firstname = driver.findElement(By.id("inputFirstName"));
        firstname.sendKeys("keren dahan");
        //make keyboard close...
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("123456");
//        driver.hideKeyboard();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputPasswordVerify")));
        WebElement verifyPassword = driver.findElement(By.id("inputPasswordVerify"));
        verifyPassword.sendKeys("123456");
        driver.hideKeyboard();
        driver.findElement(By.id("continueButton")).click();
        /**************Send code to my phone ********************************************/
        //ADD ROBOT HERE!!!!
//        Robot robot = new Robot();
//        robot.delay(5000);
//        robot.keyPress(KeyEvent.VK_0);
//        robot.keyPress(KeyEvent.VK_5);
//        robot.keyPress(KeyEvent.VK_2);
//        robot.keyPress(KeyEvent.VK_8);
//        robot.keyPress(KeyEvent.VK_2);
//        robot.keyPress(KeyEvent.VK_8);
//        robot.keyPress(KeyEvent.VK_0);
//        robot.keyPress(KeyEvent.VK_6);
//        robot.keyPress(KeyEvent.VK_1);
//        robot.keyPress(KeyEvent.VK_2);
//        robot.keyPress(KeyEvent.VK_ENTER);

//        List<MobileElement> phonedigits = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/pinBox\")");
        List<MobileElement> phonedigits = driver.findElements(By.id("pinBox"));
        phonedigits.get(0).sendKeys("0528280617");
        driver.findElement(By.id("continueButton")).click();
        driver.findElement(By.id("okButton")).click();
        //allow buy me to send text
        driver.findElement(By.id("permission_allow_button")).click();
        /*************************************************************************************/
    }
    public void loginWithEmail (AndroidDriver<MobileElement> driver, String Email){
        WebElement email = driver.findElement(By.id("inputEmail"));
        email.sendKeys(Email);
        WebElement password = driver.findElement(By.id("inputPassword"));
        password.sendKeys("123456");
        driver.findElement(By.id("continueButton")).click();
    }

}
