package WebTests;

import WebTests.ExtentReportsClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import sun.nio.ch.IOUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Lesson9IOXML {
    private static WebDriver driver; //must be static to wont die
    private static WebDriverWait wait;
    private static TxtLog log = new TxtLog();
    //private static ExtentReports extent;
    //private static ExtentTest logger;
    private static ExtentReportsClass kerenExtentReport = new ExtentReportsClass();
    @BeforeClass
    public static void Starthere(){
        System.setProperty("webdriver.chrome.driver", "C:\\AutomationMaterials\\chromeDriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,60);
        kerenExtentReport.startReport();
    }

    @Test
    public void TestXML(){
        XMLlog myxml = new XMLlog();
        String FilePath = "c://keren//lesson9.xml";
        String newXMLPath = "c://keren//newXML.xml";
        String XMLtag="URL";
        String newTag = "NewTag";
        String newTagValue = "Just in!";
        String browseToURL ;//= "https://www.google.com/";
        browseToURL=myxml.readXML(XMLtag,FilePath);
        driver.get(browseToURL);
        myxml.writeToXML(newXMLPath,newTag,newTagValue);
        kerenExtentReport.passTest("TestXML");
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();

    }
    @Test
    public void DragAndDrop(){
        driver.get("https://dgotlieb.github.io/Actions/");
        WebElement locationElement = driver.findElement(By.id("drag1"));
        WebElement destinationElement = driver.findElement(By.id("div1"));
        Actions dnd = new Actions(driver);
        dnd.clickAndHold(locationElement).moveToElement(destinationElement).build().perform();

        log.write("Drag and drop completed succsfully","c:\\keren\\log.txt");
        kerenExtentReport.failTest("DragAndDrop");
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();

    }


    @Test
    public void DblClick() throws Exception {
        driver.get("https://dgotlieb.github.io/Actions/");

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@ondblclick='doubleClickFunction()']"))));
        //logger = extent.startTest("DblClick");
        WebElement doubleClickElement = driver.findElement(By.xpath("//p[@ondblclick='doubleClickFunction()']"));
        String expactedTxt = "You double clicked";
        Actions doubleClickAction = new Actions(driver);
        doubleClickAction.doubleClick(doubleClickElement);
        doubleClickAction.build().perform();
        WebElement newtxt = driver.findElement(By.id("demo"));
        String demo = newtxt.getText();
//Assert.assertEquals(demo,expactedTxt);

//        log.write("Double click element completed succsfully","c:\\keren\\log.txt");
        String screenshoot="MyFirstScreenShoot";
        kerenExtentReport.passTest("DblClick");
        kerenExtentReport.getScreenshot(driver,screenshoot);
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();

    }
    @Test
    public void Hover(){
        driver.get("https://dgotlieb.github.io/Actions/");
        WebElement hover = driver.findElement(By.id("close"));
        Actions Hover = new Actions(driver);
        Hover.moveToElement(hover).build().perform();
        log.write("Hover Completed succsfully","c:\\keren\\log.txt");
        kerenExtentReport.passTest("Hover");
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();

    }
    @Test
    public void MultiSelect(){
        driver.get("https://dgotlieb.github.io/Actions/");
        WebElement pizza = driver.findElement(By.xpath("//select/option[@value='pizza']"));
        WebElement burger = driver.findElement(By.xpath("//select/option[@value='burger']"));
        Actions multiSelect = new Actions(driver);
        multiSelect.keyDown(Keys.CONTROL)
                .click(pizza).click(burger)
                .keyUp(Keys.CONTROL).build().perform();
        kerenExtentReport.passTest("MultiSelect");
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();

    }
    @Test
    public void scrollDown() throws InterruptedException {
        driver.get("https://dgotlieb.github.io/Actions/");
        WebElement element = driver.findElement(By.id("clickMe"));
        //scroll to location
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 350);");
        //To scroll up - jse.executeScript("scroll(0, -250);");
        //scroll to Element
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        kerenExtentReport.passTest("scrollDown");
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();

    }
    @Test
    public void uploadFile(){
        driver.get("https://dgotlieb.github.io/Actions/");
        Actions uploadfile = new Actions(driver);

        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFile.sendKeys("c:\\keren\\log.txt");
        kerenExtentReport.passTest("uploadFile");
        //kerenExtentReport.
        //log.addscreencapture....
        kerenExtentReport.endTest();
        kerenExtentReport.updateReport();


    }

    @AfterClass
    public void endReport()
    {
        kerenExtentReport.endReport();

    }
    public void javascriptDragAndDrop (WebElement source, WebElement target){
        String script="";
        try (FileInputStream inputStream = new FileInputStream("c:\\1.txt")) {
           // script = IOUtil.tostring(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        //script+= "simulatorHTML5DragAndDrop(argument[0],argument[1]"
    }



}
