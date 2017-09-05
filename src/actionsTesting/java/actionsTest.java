import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.Home;
import pages.Draggable;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import java.awt.*;

/**
 * Created by Administrator on 05/09/2017.
 */
public class actionsTest {

    private Actions builder;
    private WebDriver driver;
    private static ExtentReportManager reportManager;
    private static int ssCount = 0;

    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\ActionsTestReport",
                "Basic Extent Report","Basic Report");
//        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        builder = new Actions(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }

    @Test
    public void testDrag() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Draggable.class);

        builder.moveToElement(Home.dragPage).click().perform();

        int startX = Draggable.dragMe.getLocation().x;
        int startY = Draggable.dragMe.getLocation().y;
        builder.moveToElement(Draggable.dragMe).dragAndDropBy(Draggable.dragMe, 100, 100).perform();
        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(startX + 100, Draggable.dragMe.getLocation().x);
            assertEquals(startY + 100, Draggable.dragMe.getLocation().y);
            logLevelTest.pass("Default Drag Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void constrain1DragTest() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Draggable.class);

        builder.moveToElement(Home.dragPage).click().perform();
        builder.moveToElement(Draggable.constrainMove).click().perform();

        int sY = Draggable.consDrag1.getLocation().y;
        builder.moveToElement(Draggable.consDrag1).dragAndDropBy(Draggable.consDrag1, 0, 10).perform();

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(sY + 10, Draggable.consDrag1.getLocation().y);
            logLevelTest.pass("Constrain Drag 1 Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void constrain2DragTest() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Draggable.class);

        builder.moveToElement(Home.dragPage).click().perform();
        builder.moveToElement(Draggable.constrainMove).click().perform();

        int sX = Draggable.consDrag2.getLocation().x;
        builder.moveToElement(Draggable.consDrag2).dragAndDropBy(Draggable.consDrag2, 50, 0).perform();

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(sX + 50, Draggable.consDrag2.getLocation().x);
            logLevelTest.pass("Constrain Drag 2 Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void constrain3DragTest() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Draggable.class);

        builder.moveToElement(Home.dragPage).click().perform();
        builder.moveToElement(Draggable.constrainMove).click().perform();

        int sX = Draggable.consDrag3.getLocation().x;
        int sY = Draggable.consDrag3.getLocation().y;
        builder.moveToElement(Draggable.consDrag3).dragAndDropBy(Draggable.consDrag3, 50, 15).perform();

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(sX + 50, Draggable.consDrag3.getLocation().x);
            assertEquals(sY + 15, Draggable.consDrag3.getLocation().y);
            logLevelTest.pass("Constrain Drag 3 Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void constrain5DragTest() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Draggable.class);

        builder.moveToElement(Home.dragPage).click().perform();
        builder.moveToElement(Draggable.constrainMove).click().perform();

        int sX = Draggable.consDrag5.getLocation().x;
        int sY = Draggable.consDrag5.getLocation().y;
        builder.moveToElement(Draggable.consDrag5).dragAndDropBy(Draggable.consDrag5, 0, 5).perform();

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(sX, Draggable.consDrag5.getLocation().x);
            assertEquals(sY - 65, Draggable.consDrag5.getLocation().y);
            logLevelTest.pass("Constrain Drag 5 Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void cursorStyle1Test() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Draggable.class);

        builder.moveToElement(Home.dragPage).click().perform();
        builder.moveToElement(Draggable.cursorStyle).click().perform();

        builder.moveToElement(Draggable.cDrag1).clickAndHold(Draggable.cDrag1).perform();
        PointerInfo in = MouseInfo.getPointerInfo();
        Point point = in.getLocation();
        int mouseX = (int) point.getX();
        int mouseY = (int) point.getY();
        System.out.println("mouse " + mouseX + " " + mouseY);
        builder.release();

        builder.moveToElement(Draggable.cDrag1).dragAndDropBy(Draggable.cDrag1, 50, 50).perform();
        builder.moveToElement(Draggable.cDrag1).clickAndHold(Draggable.cDrag1).perform();
        PointerInfo inf = MouseInfo.getPointerInfo();
        Point pointer = inf.getLocation();
        int actX = (int) pointer.getX();
        int actY = (int) pointer.getY();
        System.out.println("act " + actX + " " + actY);
        builder.release();

        int expX = mouseX + 50; //doesn't recognise that the element has moved.
        int expY = mouseY + 50;
        System.out.println("exp " + expX + " " + expY);

//        String delimX = Draggable.cDrag1.getCssValue("width").substring(0,3);
//        String delimy = Draggable.cDrag1.getCssValue("height").substring(0,3);
//        System.out.println(delimX + " " + delimy);
//        int x = (Integer.parseInt(delimX));
//        int y = (Integer.parseInt(delimy));
////        int x = (Integer.parseInt(Draggable.cDrag1.getCssValue("width"))) / 2;
////        int y = (Integer.parseInt(Draggable.cDrag1.getCssValue("height"))) / 2;
//        int expX = (int) point.getX() - x;
//        int expY = (int) point.getY() - y;
//        System.out.println(expX + " " + expY);

//        builder.moveToElement(Draggable.cDrag1).dragAndDropBy(Draggable.cDrag1, 50, 50).perform();
//        builder.moveToElement(Draggable.cDrag1).clickAndHold(Draggable.cDrag1).perform();
//        PointerInfo inf = MouseInfo.getPointerInfo();
//        Point pointer = in.getLocation();
//        int actX = (int) pointer.getX();
//        int actY = (int) pointer.getY();

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(expX, actX);
            assertEquals(expY, actY);
            logLevelTest.pass("Constrain Drag 5 Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }
}
