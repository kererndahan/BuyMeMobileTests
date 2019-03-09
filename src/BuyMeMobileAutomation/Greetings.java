package BuyMeMobileAutomation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Greetings {
    private HelperMobile helper = new HelperMobile(); // TODO: 11/8/2017 keren
    public void greetings (AndroidDriver<MobileElement> driver)throws Exception{
        //helper.staticScrollDown(driver); todo keren
        WebElement to = driver.findElement(By.id("toEditText"));
        to.sendKeys("Keren Dahan");
        tryToHideKeybord(driver);

        WebElement greetings = driver.findElement(By.id("blessEditText"));
        greetings.sendKeys("Greetings!! you got gifted!");
        tryToHideKeybord(driver);
        WebElement from = driver.findElement(By.id("userFrom"));
        to.sendKeys("Santa Clous");
        tryToHideKeybord(driver);
//        driver.findElement(By.id("il.co.mintapp.buyme:id/addImage")).click();
        driver.findElement(By.id("goNextButton")).click();
    }

    void tryToHideKeybord(AndroidDriver <MobileElement> driver){
        if (driver.isKeyboardShown()) {
            try {
                driver.hideKeyboard();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
