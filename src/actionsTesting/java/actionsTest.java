import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.*;

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

//        String delimX = Draggable.cDrag1.getCssValue("width").substring(0,3);
//        String delimy = Draggable.cDrag1.getCssValue("height").substring(0,3);
//        System.out.println(delimX + " " + delimy);
//        int x = (Integer.parseInt(delimX)) / 2;
//        int y = (Integer.parseInt(delimy)) / 2;
//
//        builder.moveToElement(Draggable.cDrag1, x, y).clickAndHold(Draggable.cDrag1).perform();
        builder.moveToElement(Draggable.cDrag1).clickAndHold(Draggable.cDrag1).perform();
        PointerInfo in = MouseInfo.getPointerInfo();
        Point point = in.getLocation();
        int mouseX = (int) point.getX() + 50;
        int mouseY = (int) point.getY() + 50;
        System.out.println("mouse " + mouseX + " " + mouseY);
        builder.release();

        //builder.moveToElement(Draggable.cDrag1).dragAndDropBy(Draggable.cDrag1, 50, 50).perform();
        builder.moveToElement(Draggable.cDrag1).clickAndHold(Draggable.cDrag1).perform();
//        int actX = Draggable.cDrag1.getLocation().x;
//        int actY = Draggable.cDrag1.getLocation().y;
        builder.moveByOffset(50,50).perform();
        PointerInfo inf = MouseInfo.getPointerInfo();
        Point pointer = inf.getLocation();
        int actX = (int) pointer.getX();
        int actY = (int) pointer.getY();
        System.out.println("act " + actX + " " + actY);
        builder.release();

        builder.moveToElement(Draggable.cDrag1).clickAndHold(Draggable.cDrag1).perform();
//        int expX = Draggable.cDrag1.getLocation().x;
//        int expY = Draggable.cDrag1.getLocation().y;
        PointerInfo info = MouseInfo.getPointerInfo();
        Point pnt = info.getLocation();
        int expX = (int) pnt.getX();
        int expY = (int) pnt.getY();
        System.out.println("exp " + expX + " " + expY);
        builder.release();

//        int expX = mouseX + 50; //doesn't recognise that the element has moved.
//        int expY = mouseY + 50;
//        System.out.println("exp " + expX + " " + expY);

//        String delimX = Draggable.cDrag1.getCssValue("width").substring(0,3);
//        String delimy = Draggable.cDrag1.getCssValue("height").substring(0,3);
//        System.out.println(delimX + " " + delimy);
//        int x = (Integer.parseInt(delimX));
//        int y = (Integer.parseInt(delimy));
//        int x = (Integer.parseInt(Draggable.cDrag1.getCssValue("width"))) / 2;
//        int y = (Integer.parseInt(Draggable.cDrag1.getCssValue("height"))) / 2;
//        int expX = (int) point.getX() - x / 2;
//        int expY = (int) point.getY() - y / 2;
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
            logLevelTest.pass("Cursor Style Test Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void testDefaultDrop() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Droppable.class);

        builder.moveToElement(Home.dropPage).click().perform();
        builder.moveToElement(Droppable.defDrop).dragAndDrop(Droppable.defDrop, Droppable.defDropTarget).perform();

        String act = Droppable.defDropTargetText.getText();

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals("Dropped!", act);
            logLevelTest.pass("Default Drop Test Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void acceptDropTestNonValid() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Droppable.class);

        builder.moveToElement(Home.dropPage).click().perform();
        builder.moveToElement(Droppable.acceptTab).click().perform();
        builder.moveToElement(Droppable.nonValid).dragAndDrop(Droppable.nonValid, Droppable.acceptTarget).perform();
        String act = Droppable.acceptText.getText();
        System.out.println(act);

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals("Dropped!", act);
            logLevelTest.pass("Accept Drop Non Valid Test Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void acceptDropTestValid() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Droppable.class);

        builder.moveToElement(Home.dropPage).click().perform();
        builder.moveToElement(Droppable.acceptTab).click().perform();
       // builder.moveToElement(Droppable.valid).dragAndDropBy(Droppable.valid, 50, 50).perform();
        builder.moveToElement(Droppable.valid).dragAndDrop(Droppable.valid, Droppable.acceptTarget).perform();
        String act = Droppable.acceptText.getText();
        System.out.println(act); //act = "";

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals("Dropped!", act);
            logLevelTest.pass("Accept Drop Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void testResizableWidth() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Resizable.class);

        builder.moveToElement(Home.resizePage).click().perform();
        String delimWidth = Resizable.resizeBox.getCssValue("width").substring(0,3);
        int startWidth = (Integer.parseInt(delimWidth));
        //builder.moveToElement(Resizable.resizeWidth).clickAndHold(Resizable.resizeWidth).per
        builder.moveToElement(Resizable.resizeWidth).dragAndDropBy(Resizable.resizeWidth, 100, 0).perform();
        String delimWidth2 = Resizable.resizeBox.getCssValue("width").substring(0,3);
        int endWidth = (Integer.parseInt(delimWidth2)); //232 - 250 (-18)
        int exp = startWidth + 82; // 82 because of the padding etc.
        System.out.print(exp + " " + startWidth + " " + endWidth);

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(exp, endWidth);
            logLevelTest.pass("Resizeable Width Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void testResizableHeight() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Resizable.class);

        builder.moveToElement(Home.resizePage).click().perform();
        String delimHeight = Resizable.resizeBox.getCssValue("height").substring(0,3);
        int startHeight = (Integer.parseInt(delimHeight));
        builder.moveToElement(Resizable.resizeHeight).dragAndDropBy(Resizable.resizeHeight, 0, 100).perform();
        String delimHeight2 = Resizable.resizeBox.getCssValue("height").substring(0,3);
        int endHeight = (Integer.parseInt(delimHeight2));
        int exp = startHeight + 82; // 82 because of the padding etc.
        System.out.print(exp + " " + startHeight + " " + endHeight);

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(exp, endHeight);
            logLevelTest.pass("Resizeable Height Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void testResizableBoth() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Resizable.class);

        builder.moveToElement(Home.resizePage).click().perform();
        String delimHeight = Resizable.resizeBox.getCssValue("height").substring(0,3);
        int startHeight = (Integer.parseInt(delimHeight));
        String delimWidth = Resizable.resizeBox.getCssValue("width").substring(0,3);
        int startWidth = (Integer.parseInt(delimWidth));
        builder.moveToElement(Resizable.resizeBoth).dragAndDropBy(Resizable.resizeBoth, 100, 100).perform();
        String delimHeight2 = Resizable.resizeBox.getCssValue("height").substring(0,3);
        int endHeight = (Integer.parseInt(delimHeight2));
        int expH = startHeight + 82; // 82 because of the padding etc.
        System.out.print(expH + " " + startHeight + " " + endHeight);
        String delimWidth2 = Resizable.resizeBox.getCssValue("width").substring(0,3);
        int endWidth = (Integer.parseInt(delimWidth2));
        int expW = startWidth + 82; // 82 because of the padding etc.
        System.out.print(expW + " " + startWidth + " " + endWidth);


        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(expH, endHeight);
            assertEquals(expW, endWidth);
            logLevelTest.pass("Resizeable Both Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void defaultSelectTest() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://demoqa.com\"");
        driver.navigate().to("http://demoqa.com/");
        PageFactory.initElements(driver, Home.class);
        PageFactory.initElements(driver, Selectable.class);

        builder.moveToElement(Home.selectPage).click().perform();
        builder.moveToElement(Selectable.selectItem1).click().perform();
        String act = Selectable.selectItem1.getAttribute("class");
        String exp = "ui-widget-content ui-corner-left ui-selectee ui-selected";

        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "actionsTesting" + File.separatorChar + "java" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(exp, act);
            logLevelTest.pass("Default Selectable Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            Assert.fail();
        }
    }
}
