import com.aventstack.extentreports.ExtentTest;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.Status;

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

    @Test
    public void myTest() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"thedemosite.co.uk\"");
        webDriver.navigate().to("http://thedemosite.co.uk/");
        webDriver.findElement(By.cssSelector("a[href^=\"addauser.php\"]")).click();
        logLevelTest.log(Status.INFO, "moving to the \"add user\" page");
        webDriver.findElement(By.name("username")).sendKeys("user");
        webDriver.findElement(By.name("password")).sendKeys("pass");
        webDriver.findElement(By.name("FormsButton2")).click();
        logLevelTest.log(Status.INFO, "creating a user");
        webDriver.findElement(By.cssSelector("a[href^=\"login.php\"]")).click();
        logLevelTest.log(Status.INFO, "moving to the \"login\" page");
        webDriver.findElement(By.name("username")).sendKeys("user");
        webDriver.findElement(By.name("password")).sendKeys("pass");
        webDriver.findElement(By.name("FormsButton2")).click();
        logLevelTest.log(Status.INFO, "entering the login details created previously");
        assertEquals(webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText(), "**Successful Login**");
        logLevelTest.log(Status.INFO, "checking that the login was successful");
        logLevelTest.pass("Login test successful");
    }
}
