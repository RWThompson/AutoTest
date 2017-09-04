import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 04/09/2017.
 */
public class selenium {
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
        assertEquals(driver.getCurrentUrl(), "https://www.qa.com/");
    }

}
