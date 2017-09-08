import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.utils.StringUtil;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sun.security.krb5.internal.LoginOptions;
import webPages.AutoTraderHome;
import webPages.CreateSaleAd;
import webPages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 08/09/2017.
 */
public class AutoTraderTests {

    private Actions builder;
    private WebDriver driver;
    private static ExtentReportManager reportManager;
    private static int ssCount = 0;

    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\FridayProjectTestReport",
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
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        reportManager.clearTests();
    }

    private void assertTest(String exp, String act) {
        ExtentTest logLevelTest = reportManager.setUpTest();
        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "FridayProject"  + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(exp, act);
            logLevelTest.pass("Add to cart from home Function Passed");
        } catch (AssertionError e) {
            logLevelTest.fail("Failed test");
            logLevelTest.debug(e.getMessage());
            logLevelTest.error(e.toString());
            logLevelTest.error(e.fillInStackTrace());
            e.printStackTrace();
            Assert.fail();
        }
    }

    private void select(WebElement el, String value) {
        Select select = new Select(el);
        select.selectByValue(value);
    }

    private void waiter(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> getData(int i) {
        ArrayList<String> data = new ArrayList<String>();
        SpreadSheetReaderFri sheetReader = new SpreadSheetReaderFri(System.getProperty("user.dir") + "/src/main/resources/friProjData.xlsx");
        int[] numberOfRows = {1};
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

    @Test
    public void searchAllCarsWithin5Miles() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "Opening the website \"http://www.autotrader.co.uk/\"");
        driver.navigate().to("http://www.autotrader.co.uk/");
        PageFactory.initElements(driver, AutoTraderHome.class);

        logLevelTest.log(Status.INFO, "Entering the postcode into the search area");
        builder.moveToElement(AutoTraderHome.postcode).sendKeys(AutoTraderHome.postcode, "M50 3YJ").perform();
        logLevelTest.log(Status.INFO, "Clicking on the select distance drop down");
        builder.moveToElement(AutoTraderHome.distance).click().perform();
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the drop down menu to appear");
        waiter(2);
        logLevelTest.log(Status.INFO, "Selecting 5 miles in the drop down menu");
        select(AutoTraderHome.distance, "5");
        logLevelTest.log(Status.INFO, "Clicking the search button");
        builder.moveToElement(AutoTraderHome.searchBut).click().perform();

        logLevelTest.log(Status.INFO, "Retrieving the current URL");
        String act = driver.getCurrentUrl();
        String exp = "https://www.autotrader.co.uk/car-search?postcode=m503yj&radius=5&onesearchad=Used&onesearchad=Nearly%20New&onesearchad=New&search-target=usedcars&is-quick-search=true&quicksearch=true";
        assertTest(exp, act);
    }

    @Test
    public void testYoutubeLink() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "Opening the website \"http://www.autotrader.co.uk/\"");
        driver.navigate().to("http://www.autotrader.co.uk/");
        PageFactory.initElements(driver, AutoTraderHome.class);

        logLevelTest.log(Status.INFO, "Clicking the youtube link button");
        builder.moveToElement(AutoTraderHome.ytLink).click().perform();
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the youtube page to load");
        waiter(2);

        logLevelTest.log(Status.INFO, "Retrieving the current URL");
        String act = driver.getCurrentUrl();
        String exp = "https://www.youtube.com/user/autotraderuk?sub_confirmation=1";
        assertTest(exp, act);
    }

    @Test
    public void testCreateAdNonValidReg() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "Opening the website \"http://www.autotrader.co.uk/\"");
        driver.navigate().to("http://www.autotrader.co.uk/");
        PageFactory.initElements(driver, AutoTraderHome.class);
        PageFactory.initElements(driver, CreateSaleAd.class);

        logLevelTest.log(Status.INFO, "Entering a non valid registration number to the create advert section");
        builder.moveToElement(AutoTraderHome.sellReg).sendKeys(AutoTraderHome.sellReg, "BK03 XSY").perform();
        logLevelTest.log(Status.INFO, "Entering a number for the mileage");
        builder.moveToElement(AutoTraderHome.sellMileage).sendKeys(AutoTraderHome.sellMileage, "70000").perform();
        logLevelTest.log(Status.INFO, "Clicking the create advert button");
        builder.moveToElement(AutoTraderHome.createSell).click().perform();
        logLevelTest.log(Status.INFO, "Waiting for 2 seconds so that the website can redirect to the new page");
        waiter(2);

        logLevelTest.log(Status.INFO, "Retrieving the error message");
        String act = CreateSaleAd.error.getText();
        String exp = "We are unable to place this advert. Please contact our Customer Security Team on 0330 303 9001.";
        assertTest(exp, act);
    }

    @Test
    public void findCarsByModel() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "Opening the website \"http://www.autotrader.co.uk/\"");
        driver.navigate().to("http://www.autotrader.co.uk/");
        PageFactory.initElements(driver, AutoTraderHome.class);

        logLevelTest.log(Status.INFO, "Entering the postcode into the search area");
        builder.moveToElement(AutoTraderHome.postcode).sendKeys(AutoTraderHome.postcode, "M50 3YJ").perform();
        logLevelTest.log(Status.INFO, "Clicking on the select distance drop down");
        builder.moveToElement(AutoTraderHome.distance).click().perform();
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the drop down menu to appear");
        waiter(2);
        logLevelTest.log(Status.INFO, "Selecting 10 miles in the drop down menu");
        select(AutoTraderHome.distance, "10");
        logLevelTest.log(Status.INFO, "Clicking on the select make drop down");
        builder.moveToElement(AutoTraderHome.make).click().perform();
        logLevelTest.log(Status.INFO, "Waiting for 2 seconds for the drop down menu to show up");
        waiter(2);
        logLevelTest.log(Status.INFO, "Selecting the Ford option");
        select(AutoTraderHome.make, "FORD");
        logLevelTest.log(Status.INFO, "Clicking on the select model drop down");
        builder.moveToElement(AutoTraderHome.model).click().perform();
        logLevelTest.log(Status.INFO, "Waiting for 2 seconds for the drop down menu to show up");
        waiter(2);
        logLevelTest.log(Status.INFO, "Selecting the Fiesta option");
        select(AutoTraderHome.model, "FIESTA");
        logLevelTest.log(Status.INFO, "Clicking the search button");
        builder.moveToElement(AutoTraderHome.searchBut).click().perform();

        String act = driver.getCurrentUrl();
        String exp = "https://www.autotrader.co.uk/car-search?make=FORD&model=FIESTA&postcode=m503yj&radius=10&onesearchad=Used&onesearchad=Nearly%20New&onesearchad=New&search-target=usedcars&is-quick-search=true&quicksearch=true";
        assertTest(exp, act);
    }

    @Test
    public void testLogin() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "Opening the website \"http://www.autotrader.co.uk/\"");
        driver.navigate().to("http://www.autotrader.co.uk/");
        PageFactory.initElements(driver, AutoTraderHome.class);
        PageFactory.initElements(driver, LoginPage.class);

        logLevelTest.log(Status.INFO, "Retrieving the stored test data");
        ArrayList<String> data = getData(1);
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the data to be retrieved");
        waiter(2);

        logLevelTest.log(Status.INFO, "Clicking the sign in button");
        builder.moveToElement(AutoTraderHome.signIn).click().perform();
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the page to be loaded");
        waiter(2);
        logLevelTest.log(Status.INFO, "Inputting the stored email to the email box");
        builder.moveToElement(LoginPage.email).sendKeys(LoginPage.email, data.get(0)).perform();
        logLevelTest.log(Status.INFO, "Inputting the stored password into the password box");
        builder.moveToElement(LoginPage.pass).sendKeys(LoginPage.pass, data.get(1)).perform();
        logLevelTest.log(Status.INFO, "Clicking the login button");
        builder.moveToElement(LoginPage.submit).click().perform();
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the user details page to load");
        waiter(2);
        
        String act = driver.findElement(By.tagName("body")).getAttribute("id");
        String exp = "myAccountDetails";
        assertTest(exp, act);
    }
}
