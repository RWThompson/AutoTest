import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by Administrator on 04/09/2017.
 */
public class firstTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void myTest() {
        driver.navigate().to("https://www.qa.com");
    }

    @Test
    public void helloWorldTest() {
        System.out.println("Hello World");
    }
}
