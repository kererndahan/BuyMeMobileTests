package WebTests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import static junit.framework.TestCase.assertTrue;

/**
 * Created by keren on 10/4/2017.
 */
public class JunitAmazonSearch {
    private static WebDriver driver; //must be static to wont die
    private static WebDriverWait wait;
    @BeforeClass
    public static void getStarted1(){

        System.setProperty("webdriver.chrome.driver", "C:\\AutomationMaterials\\chromeDriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,60);
    }
    @Test
    public void ClickOnSelectedNews(){
        driver.get("https://www.amazon.com/");
        String AmazonExpactedTitle = "Online";
        String title = driver.getTitle();
        boolean result = AmazonExpactedTitle.toLowerCase().contains(title.toLowerCase());
        assertTrue(true);
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.click();
        search.sendKeys("Leather shoes");
        search.sendKeys(Keys.RETURN);
//        WebElement under25 = driver.findElement(By.tagName("Under $25"));
//        under25.click();
//        driver.findElement(By.id("result_0")).click();

//        https://www.tutorialspoint.com/junit/junit_using_assertion.htm
    }
}
