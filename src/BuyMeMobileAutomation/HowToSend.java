package BuyMeMobileAutomation;

import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HowToSend {
    private HelperMobile helper = new HelperMobile();
    public void send (AndroidDriver<MobileElement> driver, WebDriverWait wait, ExtentTest test, String Email)throws Exception {
        helper.staticScrollDown(driver);
        WebElement sendNow = driver.findElement(By.id("nowRadioButton"));
        WebElement sendLater = driver.findElement(By.id("futureRadioButton"));
        List<MobileElement> options = driver.findElements(By.id("optionCheckBox"));
        options.get(0).click();
        options.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description")));
        List<MobileElement> description = driver.findElements(By.id("description"));
        WebElement smsTxtBox = description.get(0);
        smsTxtBox.sendKeys("0528280614");
        WebElement emailTxtBox = description.get(1);
        emailTxtBox.sendKeys("kerenstore03@gmail.com");
        driver.findElement(By.id("goNextButton")).click();
    }
}
