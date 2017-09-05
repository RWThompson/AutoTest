package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 05/09/2017.
 */
public class Home {

    @FindBy(css = "#menu-item-140 > a")
    public static WebElement dragPage;

    @FindBy(css = "#menu-item-141 > a")
    public static WebElement dropPage;

    @FindBy(css = "#menu-item-143 > a")
    public static WebElement resizePage;

    @FindBy(css = "#menu-item-142 > a")
    public static WebElement selectPage;

    @FindBy(css = "#menu-item-151 > a")
    public static WebElement sortPage;
}
