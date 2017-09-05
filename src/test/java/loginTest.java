import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pages.addUser;
import pages.login;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 04/09/2017.
 */
public class loginTest {

    private WebDriver webDriver;
    private static ExtentReportManager reportManager;

    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\TestReport",
                "Basic Extent Report","Basic Report");
//        reportDetails.setTheme(Theme.DARK);
        reportManager = new ExtentReportManager(ExtentReportManager.ReportType.HTML,reportDetails);
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp(){
        reportManager.clearTests();
    }

    private int ssCount = 0;
    private void assertTest(ExtentTest logTest, String act, String exp) {
        try {
            Assert.assertEquals(act,exp);
            logTest.pass("Login test successful");
        } catch (AssertionError e) {
            logTest.fail("Failed test");
            logTest.debug(e.getMessage());
            try {
                //test.addScreenCaptureFromPath(ScreenShot.take(driver, "reports"+ File.separatorChar +"screenshots"+File.separatorChar +"test-screenshot-" + screenShotCount++));
                logTest.addScreenCaptureFromPath(ScreenShot.take(webDriver, "report" + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
            } catch (IOException exe) {
                logTest.info("Failed to take screen shot");
                logTest.debug(exe.getMessage());
            }
            Assert.fail();
        }
    }

    private ArrayList<String> getData(int i) {
        ArrayList<String> data = new ArrayList<String>();
        SpreadSheetReader sheetReader = new SpreadSheetReader(System.getProperty("user.dir") + "/src/main/resources/testData.xlsx");
        int[] numberOfRows = {1,2};
        for (int rowNo : numberOfRows) {
            sheetReader.readRow(rowNo, "Sheet1");
        }
        List<String> row = sheetReader.readRow(i, "Sheet1");
        for(String cell : row) {
            data.add(cell);
            System.out.println(cell);
        }
        return data;
    }

    private void waitMethod(String s) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement we = wait.until(
                (Function<WebDriver, WebElement>) func -> func.findElement(By.name(s)));

//                new Function<WebDriver, WebElement>() {
//           public WebElement apply(WebDriver driver, String s) {
//               return driver.findElement(By.name(s));
//           }
//        });
    }

    @Test
    public void extentReportTest() {
        ArrayList<String> data = getData(1);
        ExtentTest logLevelTest = reportManager.setUpTest();
        PageFactory.initElements(webDriver, addUser.class);
        PageFactory.initElements(webDriver, login.class);

        logLevelTest.log(Status.INFO, "opening the website \"thedemosite.co.uk\"");
        webDriver.navigate().to("http://thedemosite.co.uk/");
        webDriver.findElement(By.cssSelector("a[href^=\"addauser.php\"]")).click();
        logLevelTest.log(Status.INFO, "moving to the \"add user\" page");
        //waitMethod(addUser.butEle.);

        addUser.userEle.sendKeys(data.get(0));
        addUser.passEle.sendKeys(data.get(1));
        addUser.butEle.click();
        logLevelTest.log(Status.INFO, "creating a user");
        webDriver.findElement(By.cssSelector("a[href^=\"login.php\"]")).click();
        logLevelTest.log(Status.INFO, "moving to the \"login\" page");
        //waitMethod(login.butEle.getTagName());

        login.userEle.sendKeys(data.get(2));
        login.passEle.sendKeys(data.get(3));
        login.butEle.click();
        logLevelTest.log(Status.INFO, "entering the login details created previously");
        assertTest(logLevelTest, webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText(), "**Successful Login**");
        logLevelTest.log(Status.INFO, "checking that the login was successful");
    }

    @Test
    public void extentReportTest2() {
        ArrayList<String> data = getData(2);
        ExtentTest logLevelTest = reportManager.setUpTest();
        PageFactory.initElements(webDriver, addUser.class);
        PageFactory.initElements(webDriver, login.class);

        logLevelTest.log(Status.INFO, "opening the website \"thedemosite.co.uk\"");
        webDriver.navigate().to("http://thedemosite.co.uk/");
        webDriver.findElement(By.cssSelector("a[href^=\"addauser.php\"]")).click();
        logLevelTest.log(Status.INFO, "moving to the \"add user\" page");
        //waitMethod(addUser.butEle.getTagName());

        login.userEle.sendKeys(data.get(2));
        login.passEle.sendKeys(data.get(3));
        login.butEle.click();
        logLevelTest.log(Status.INFO, "creating a user");
        webDriver.findElement(By.cssSelector("a[href^=\"login.php\"]")).click();
        logLevelTest.log(Status.INFO, "moving to the \"login\" page");

        //waitMethod(login.butEle.getTagName());
        login.userEle.sendKeys(data.get(2));
        login.passEle.sendKeys(data.get(3));
        login.butEle.click();
        logLevelTest.log(Status.INFO, "entering the login details created previously");
        assertTest(logLevelTest, webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText(), "**Successful Login**");
        logLevelTest.log(Status.INFO, "checking that the login was successful");
    }
}
