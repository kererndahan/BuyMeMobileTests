package WebTests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.view.ScreenshotHtml;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class reports {
    private static WebDriver driver;

    //    @Rule
    //public TestName = new TestName();
private static ExtentReports report = new ExtentReports("c://keren//reports.html",false);
private static ExtentTest test = report.startTest("MyTest","Sanity Web Site test");
@BeforeClass
public static void beforeClass(){
    System.setProperty("webdriver.chrome.driver", "C:\\AutomationMaterials\\chromeDriver.exe");
    driver = new ChromeDriver();
    report.addSystemInfo("Environment","Production");
    //log information into a report
    test.log(LogStatus.ERROR,"Connection driver","before test methoda");
    //test.log(LogStatus.PASS, ScreenshotHtml);

}


private static String takeScreenShot (WebDriver driver,String ImagePath){
    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    File destinationFile = new File (ImagePath+".jpg");
    try {
        FileUtils.copyFile(screenShotFile, destinationFile);
    }
    catch (IOException e)
    {
        System.out.println(e.getMessage());
    }
    return ImagePath+".jpg";
}
    @Test
public  void main() {
    System.out.println("Hi");
    test.log(LogStatus.PASS,"taking screen shot",test.addScreenCapture(takeScreenShot(driver,"C:\\"+"name.getMethodName()")));
}
@AfterClass
public static void afterClass() {
    //test.log(LogStatus.ERROR,"First Test", "failed after blablabla");
    //System.out.println("done");
    report.endTest(test);
    report.flush();
}
}

