package WebTests;//import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngular;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;

import static org.assertj.core.api.Assertions.*;

public class WebCalculator {
    private static WebDriver driver;
    private static WebDriverWait wait;
    @BeforeClass
    public static void starthere() {
        System.setProperty("webdriver.chrome.driver", "C:\\AutomationMaterials\\chromeDriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);
    }
    @Test
    public void Calc() throws InterruptedException {
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        driver.manage().window().maximize();
        WebElement seven = driver.findElement(By.id("seven"));
        WebElement six = driver.findElement(By.id("six"));
        WebElement eight = driver.findElement(By.id("eight"));

        WebElement add = driver.findElement(By.id("add"));
        WebElement multiply = driver.findElement(By.id("multiply"));
        WebElement equal = driver.findElement(By.id("equal"));


        int sevenWidth = seven.getSize().getWidth();
        int sevenHight = seven.getSize().getHeight();
        int result;
        int expactedResult = 13;
        System.out.println("Seven width Is "+sevenWidth+" pixels");
        System.out.println("Seven Height is" +sevenHight+ " pixels");
        //check if six is displayed
        if (six.isDisplayed())
            System.out.println("Six is Displayed!");
        else System.out.println("Six is invisable!");
        //wait.until(ExpectedConditions.visibilityOf(six));
        result = Integer.parseInt(six.getText()) + Integer.parseInt(seven.getText()); // + seven.getText();
        assertThat(result).isEqualTo(expactedResult);//Nothing is returned here... see why
        Assert.assertTrue(result==expactedResult);

    }
    @Test
    public  void testB() {
        driver.get("https://dgotlieb.github.io/WebCalculator/");
        driver.manage().window().maximize();
        WebElement two = driver.findElement(By.id("two"));
        WebElement six = driver.findElement(By.id("six"));
        WebElement nine = driver.findElement(By.id("nine"));
        //Array int expactedNine = new Array(2);
        int nineHeihgt = two.getSize().getHeight();
        int nineWidth = six.getSize().getWidth();
        String nineHW ="(" + six.getSize().getWidth()+ ", " + two.getSize().getHeight()+")";
        System.out.println(two.getSize().getHeight());
        System.out.println(six.getSize().getWidth());
        System.out.println(nine.getSize());
        System.out.println(nineHW);
        Assert.assertEquals(String.valueOf(six.getSize()),nineHW);//to see error
        Assert.assertEquals(String.valueOf(nine.getSize()),nineHW);//to see error
    }
    @Test
    public void testC() throws InterruptedException {
        driver.navigate().to("https://dgotlieb.github.io/Selenium/synchronization.html");
        //driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
        //driver.manage().window().maximize();
        driver.findElement(By.id("btn")).click();
        //use Implicit to wait for new Element
        Thread.sleep(20000);
//        driver.findElement(By.id("checkbox")).click();
        //press show hidden
        driver.findElement(By.id("hidden")).click();
        Thread.sleep(10000);
        WebElement finish = driver.findElement(By.id("finish1"));
        finish.click();
        System.out.println(finish.getText());
        driver.findElement(By.id("rendered")).click();
        //WHY CANY HE FIND FINISH2?
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish2"))));
        System.out.println(driver.findElement(By.id("finish2")).getText());
        //wait.until(ExpectedConditions.visibilityOf())
    }
    @Test
    public void testD(){
//        using https://github.com/paul-hammant/ngWebDriver
        driver.navigate().to("https://dgotlieb.github.io/Selenium/synchronization.html");
        //ngWebDriver.waitForAngularRequestsToFinish();
        WebElement firstname = driver.findElement(ByAngular.model("firstName"));
        //driver.findElement(ByAngular.model('person.name'));

        //driver.findElement(Byng)
    }

}
