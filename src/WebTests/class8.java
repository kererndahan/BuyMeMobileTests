package WebTests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class class8 {
    private static WebDriver driver; //must be static to wont die
    private static WebDriverWait wait;
    @BeforeClass
    public static void GettingStarted() {
        System.setProperty("webdriver.chrome.driver", "C:\\AutomationMaterials\\chromeDriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,60);

    }
    @Test
    public void MyTest() throws InterruptedException {
        driver.get("http://edition.cnn.com/");
       // Thread.sleep(10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu")));
        driver.findElement(By.id("menu")).click();
        try {
            driver.findElement(By.className("breaking-news__close-btn")).click();
        }
        catch (Exception E){}
        WebElement search = driver.findElement(By.id("search-input-field"));
        search.click();
        search.sendKeys("trump");
        search.sendKeys(Keys.RETURN);        //wait.until("")
        List<WebElement> results = driver.findElements(By.className("cnn-search__result-headline"));
        //run on all ememnts - and print for ()
        for (int i=0;i<results.size();i++) {
            System.out.println(results.get(i).getText());
        }
        }
    }

