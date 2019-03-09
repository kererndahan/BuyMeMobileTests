package BuyMeMobileAutomation;

//import FinelWebAutomationProject.*;
//import FinelWebAutomationProject.Helper;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SanityMobile {
    public static WebDriver wdriver;
    public static WebDriverWait wait;

    @Rule
    public TestName name = new TestName();
    // report location & details
    private static AndroidDriver<MobileElement> driver;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static ExtentReports extent = new ExtentReports("C:\\Users\\Daniel\\Desktop\\Keren - Buy me mobile\\report.html", false);
    public static ExtentTest test = extent.startTest("Buy me! ", "Keren's Automation project");
    private static HelperMobile myHelper = new HelperMobile();
    private static RegistrationScreenMobile register = new RegistrationScreenMobile();
    private static ChooseGiftScreenMobile gift = new ChooseGiftScreenMobile();
    private static Greetings greetings= new Greetings();
    private static HowToSend send = new HowToSend();

    @BeforeClass
    public static void beforeMyClass() throws Exception {
        OpenBuyMeApp();
        wait = new WebDriverWait(driver, 30);
        extent.addSystemInfo("Environment","Production");
        //test.log(LogStatus.INFO, "Selected Browser", browserType);
    }
// @Test
    public void Registeration() throws Exception {
     int randomNum = 10 + (int) (Math.random() * 1000);
     String email = "kerenstore03+" + Integer.toString(randomNum) + "@gmail.com";
     test.log(LogStatus.INFO, "Logging you in....");
     /***************Start with click on Skip**********************************/
     driver.findElement(By.id("skipButton")).click();
     /***************Select Register With Email****************************************************/
     WebElement registerWithEmail = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/emailButton\")");
     registerWithEmail.click();
     try {
         /**** ******Register With Email - to use this change Email address in function***************************/
         register.registerWithEmail(driver, wait, email);
     } catch (Exception e) {
         /*****************login with Email******************************************/
         register.loginWithEmail(driver, email);
     }
 }
 @Test
 public void selectGift() throws Exception {
     driver.findElement(By.id("il.co.mintapp.buyme:id/skipButton")).click();
     driver.findElement(By.id("il.co.mintapp.buyme:id/skipTitle")).click();
//     wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"il.co.mintapp.buyme:id/t_title\")")));
     /*****************select gift******************************************/
//        gift.selectGift(driver,wait,test);

     // TODO: 11/8/2017 keren
     WebDriverWait wait = new WebDriverWait(driver, 60);
     MobileElement chooseBreakfast = driver.findElement(By.id("il.co.mintapp.buyme:id/t_title"));
     wait.until(ExpectedConditions.visibilityOf(chooseBreakfast));
     chooseBreakfast.click();

     List<MobileElement> breakfastElements = driver.findElements(By.id("il.co.mintapp.buyme:id/businessName"));

     breakfastElements.get(1).click();

     Thread.sleep(3000);


        gift.selectGiftAmount("500",driver,wait,test);
     /******************Send Gift********************************************/
        greetings.greetings(driver);
        send.send(driver,wait,test,"keren@xmpie.com");
 }


    public static void OpenBuyMeApp() throws MalformedURLException {
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

    @AfterClass
    public static void afterClass() {
        test.log(LogStatus.INFO,"Test Completed", test.addScreenCapture(HelperMobile.takeScreenShot("done",driver)));
        driver.quit();
        extent.endTest(test);
        extent.flush();
    }
}
