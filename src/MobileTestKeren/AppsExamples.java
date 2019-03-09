package MobileTestKeren;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import android.support.test.uiautomator.UiSelector;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppsExamples {
    private static AndroidDriver<MobileElement> driver;
//    private static XCUITest Driver1;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static File appDir = new File ("C:\\users\\keren\\downloads"); //NOT a real path..dont realy have the apk
    private static File app = new File (appDir, "app-debug.apk");


    @BeforeClass
    public static void setUp() throws IOException {
    //apk share

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Device");
        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);
        capabilities.setCapability("appPackage", "il.co.mintapp.buyme");
        capabilities.setCapability("appActivity", "il.co.mintapp.buyme.activities.common.SplashScreen");
        capabilities.setCapability("Full Reset",true);

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);


        //wd is web driver; hub is for working with multiopel devices. it wil allways be /wd/hub
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    //to install app instead on openings it: use App & NewCommanTimeOut instead of appPackage & appAcitivity.

    @Test
    public void clickOnGift()
    {WebDriverWait wait = new WebDriverWait(driver, 60);
//      driver.navigate().back();
        driver.findElement(By.id("il.co.mintapp.buyme:id/skipButton")).click();
        driver.findElement(By.id("il.co.mintapp.buyme:id/skipTitle")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("il.co.mintapp.buyme:id/t_title")));
        List<MobileElement> category  = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/t_title\")");
        category.get(0).click();
        /************scroll****************************************/
//        TouchAction action=new TouchAction(driver);
//        Duration threeSecondsDuration= Duration.ofSeconds(5);//AppsExamples(3);
        /**************************************************************/
        List<MobileElement> buisness  = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/t_title\")");
        //buisness.get(4).click();
        buisness.get(buisness.size() - 1).click();
        System.out.println("buisness.size() "+ buisness.size());
        List<MobileElement> optionsInBuisness = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/businessName\")");
        optionsInBuisness.get(optionsInBuisness.size() - 1).click();
        System.out.println("optionsInBuisness.size() "+ optionsInBuisness.size());

        WebElement price = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/priceEditText\")"); //il.co.mintapp.buyme:id/priceEditText
        price.sendKeys("100");
        WebElement purchesButton = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/purchaseButton\")"); //il.co.mintapp.buyme:id/priceEditText
        purchesButton.click();
        //il.co.mintapp.buyme:id/purchaseButton
//        "il.co.mintapp.buyme:id/businessImage""
//        System.out.println(element.get(0).getText());

   }
    public void justClick(){
        List<MobileElement> element  = driver.findElementsByAndroidUIAutomator("new UiSelector().resourceid('il.co.mintapp.buyme:id/t_title')");
        element.get(0).click();
    }
    public void test1_skipIntro() throws InterruptedException, IOException {


//        WebElement skipButton = driver.findElement(By.id("il.co.mintapp.buyme:id/skipButton"));
//                skipButton.click();
        /*** there are 3 options when you start,#1 you get right to the landing page,
         #2 you get to skip button , #3  you get to yellow registration button*/
//        try{ //try select a categorey
//            WebElement fashion = driver.findElement(By.linkText("גיפט קארד למותגי אופנה"));
//            fashion.click();
//        }
//        catch (Exception e){ //else try click on skip
//            try{
//                WebElement skipButton = driver.findElement(By.id("il.co.mintapp.buyme:id/skipTitle"));
//                skipButton.click();
//            }
//            catch (Exception b){ //else try to click on back then skip
//                driver.navigate().back();
//                WebElement skipButton = driver.findElement(By.id("il.co.mintapp.buyme:id/skipTitle"));
//                skipButton.click();
//            }
//        }

        //WebElement introSkipButton = driver.findElement(By.id("il.co.mintapp.buyme:id/skipButton"));
//        wait.until(ExpectedConditions.visibilityOf(introSkipButton));
//        introSkipButton.click();
    }
    public void checkIfAppIsInstalled(){
        if (driver.isAppInstalled("il.co.mintapp.buyme"))
        {
            capabilities.setCapability("appPackage", "il.co.mintapp.buyme");
            capabilities.setCapability("appActivity", "il.co.mintapp.buyme.activities.common.SplashScreen");
        }
        else{
            capabilities.setCapability("app",app.getAbsolutePath());
        }
    }
    @AfterClass
    public static void tearDown() throws IOException, InterruptedException {

//        driver.quit();
    }
}