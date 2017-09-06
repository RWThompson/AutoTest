package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 06/09/2017.
 */
public class Resizable {

    @FindBy(id = "resizable")
    public static WebElement resizeBox;
//
//    @FindBy(css = "#resizable > h3")
//    public static WebElement resizeBox;

    @FindBy(css = "#resizable > div.ui-resizable-handle.ui-resizable-e")
    public static WebElement resizeWidth;

    @FindBy(css = "#resizable > div.ui-resizable-handle.ui-resizable-s")
    public static WebElement resizeHeight;

    @FindBy(css = "#resizable > div.ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se")
    public static WebElement resizeBoth;
}
