package BuyMeMobileAutomation;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class ChooseGiftScreenMobile {
    HelperMobile myHelper = new HelperMobile();
    public void selectGift(AndroidDriver<MobileElement> driver, WebDriverWait wait, ExtentTest test) throws InterruptedException {
        test.log(LogStatus.INFO, "Entered SelectGift Function");
        Thread.sleep(10000);
        test.log(LogStatus.PASS, "status after sleep", test.addScreenCapture(HelperMobile.takeScreenShot("sleep", driver)));
        try {
            /**********Click on last shown buisness****************************************************************/
//            List<MobileElement> buisness = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/t_title\")");
//            List<MobileElement> buisness = driver.findElements(By.id("t_title"));
            List<MobileElement> buisness = driver.findElements(By.className("android.widget.RelativeLayout"));
            List<MobileElement> clickable = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(1)");
            test.log(LogStatus.INFO, "number of buisnesses found:" + buisness.size());
            test.log(LogStatus.INFO, "number of clickable found:" + clickable.size());
            clickable.get(clickable.size()-1).click();
//            buisness.get(buisness.size() - 1).click();
            /***********Click on Gift from buisness****************************************************************/
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("businessName")));
            List<MobileElement> gift = driver.findElements(By.id("businessName"));
            gift.get(buisness.size() - 1).click();
            test.log(LogStatus.PASS, "Select Gift succsfully: " , test.addScreenCapture(HelperMobile.takeScreenShot("R2", driver)));
        }
        catch (Exception e) {
            test.log(LogStatus.FAIL, "FAILEd to Select Gift! " , test.addScreenCapture(HelperMobile.takeScreenShot("R3", driver)));

        }
        finally {
            test.log(LogStatus.PASS, "Selected Gift", test.addScreenCapture(HelperMobile.takeScreenShot("R4", driver)));
        }
    }

    public void selectGiftAmount(String sum,AndroidDriver<MobileElement> driver, WebDriverWait wait, ExtentTest test ){
            test.log(LogStatus.INFO, "Entered selectGiftAmount Function");
            WebElement price = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/priceEditText\")"); //il.co.mintapp.buyme:id/priceEditText
            price.sendKeys(sum);
            WebElement purchesButton = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/purchaseButton\")"); //il.co.mintapp.buyme:id/priceEditText
            purchesButton.click();
        }
    }


