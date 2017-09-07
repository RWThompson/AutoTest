import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.base.Function;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.HomePage;
import pages.ContactPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 07/09/2017.
 */
public class advShoppingTest {

    private Actions builder;
    private WebDriver driver;
    private static ExtentReportManager reportManager;
    private static int ssCount = 0;

    @BeforeClass
    public static void init(){
        String property = System.getProperty("user.dir");
        ReportDetails reportDetails = new ReportDetails(property + "\\AdvShoppingTestReport",
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

    private void waitForAddButton() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement we = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(HomePage.addButton.toString()));
            }
        });
    }

    private void waitForProceedButton() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement we = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(String.valueOf(HomePage.proceed)));
            }
        });
    }

    private void waitForCart() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement we = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(HomePage.productsInCart.toString()));
            }
        });
    }

    private void timeout(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addToCartFromHome() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://automationpractice.com/index.php\"");
        driver.navigate().to("http://automationpractice.com/index.php");
        PageFactory.initElements(driver, HomePage.class);


        logLevelTest.log(Status.INFO, "Clicking on the blouse item");
        builder.moveToElement(HomePage.item).click().perform();
        logLevelTest.log(Status.INFO, "Clicking on the add to cart button");
        builder.moveToElement(HomePage.addProduct).click().perform();
        logLevelTest.log(Status.INFO, "Clicking on the exit button on the pop up window");
        builder.moveToElement(HomePage.exitPopUp).click().perform();
        logLevelTest.log(Status.INFO, "Waiting for 2 seconds to allow for the pop up window to disappear");
        timeout(2);
        logLevelTest.log(Status.INFO, "Retrieving the amount of products in the cart");
        int act = Integer.parseInt(HomePage.productsInCart.getText());
        int exp = 1;


        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "shoppingAdvanced"  + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
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

    @Test
    public void testYoutubeLink() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://automationpractice.com/index.php\"");
        driver.navigate().to("http://automationpractice.com/index.php");
        PageFactory.initElements(driver, HomePage.class);

        logLevelTest.log(Status.INFO, "Finding and clicking the youtube link");
        builder.moveToElement(HomePage.ytLink).click().perform();
        logLevelTest.log(Status.INFO, "Retrieving the tab titles");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        logLevelTest.log(Status.INFO, "Switching to the second tab");
        driver.switchTo().window(tabs.get(1));
        logLevelTest.log(Status.INFO, "Retrieving the current URL");
        String url = driver.getCurrentUrl();
        String exp = "https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA";


        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "shoppingAdvanced"  + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
        } catch (IOException exe) {
            logLevelTest.info("Failed to take screen shot");
            logLevelTest.debug(exe.getMessage());
        }
        try {
            assertEquals(exp, url);
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

    @Test
    public void testNewsletterSignUp() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://automationpractice.com/index.php\"");
        driver.navigate().to("http://automationpractice.com/index.php");
        PageFactory.initElements(driver, HomePage.class);

        logLevelTest.log(Status.INFO, "Inputting an email into the register email input");
        builder.moveToElement(HomePage.email).sendKeys(HomePage.email, "testR" + System.currentTimeMillis() + "@testR.com");
        logLevelTest.log(Status.INFO, "Clicking the submit button");
        builder.moveToElement(HomePage.submit).click().perform();
        logLevelTest.log(Status.INFO, "Waiting 2 seconds for the message to appear");
        timeout(2);
        logLevelTest.log(Status.INFO, "Retrieving whether or not the sign up was successful");
        String act = HomePage.success.getText();
        String exp = "Newsletter : You have successfully subscribed to this newsletter.";


        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "shoppingAdvanced"  + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
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

    @Test
    public void testContact() {
        ExtentTest logLevelTest = reportManager.setUpTest();
        logLevelTest.log(Status.INFO, "opening the website \"http://automationpractice.com/index.php\"");
        driver.navigate().to("http://automationpractice.com/index.php");
        PageFactory.initElements(driver, HomePage.class);
        PageFactory.initElements(driver, ContactPage.class);

        builder.moveToElement(HomePage.contactLink).click().perform();
        builder.moveToElement(ContactPage.contSelect).click().perform();
        builder.moveToElement(ContactPage.selDept).click().perform();
        builder.moveToElement(ContactPage.contEmail).sendKeys(ContactPage.contEmail, "testR" + System.currentTimeMillis() + "@testR.com");
        builder.moveToElement(ContactPage.msg).sendKeys(ContactPage.msg, "Message to be sent to customer serivces");
        builder.moveToElement(ContactPage.sendMsg).click().perform();
        timeout(3);
        String act = ContactPage.successCont.getText();
        String exp = "Your message has been successfully sent to our team.";


        try {
            logLevelTest.addScreenCaptureFromPath(ScreenShot.take(driver, "src" + File.separatorChar + "shoppingAdvanced"  + File.separatorChar + "screenshots" + File.separatorChar + "testSS" + ssCount++));
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
}
