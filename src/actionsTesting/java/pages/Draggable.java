package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 05/09/2017.
 */
public class Draggable {

    @FindBy(id = "draggable")
    public static WebElement dragMe;

    @FindBy(css = "#ui-id-2")
    public static WebElement constrainMove;

    @FindBy(id = "draggabl")
    public static WebElement consDrag1;

    @FindBy(id = "draggabl2")
    public static WebElement consDrag2;

    @FindBy(id = "draggabl3")
    public static WebElement consDrag3;

    @FindBy(id = "draggabl5")
    public static WebElement consDrag5;

    @FindBy(css = "#ui-id-3")
    public static WebElement cursorStyle;

    @FindBy(id = "drag")
    public static WebElement cDrag1;

    @FindBy(id = "drag2")
    public static WebElement cDrag2;

    @FindBy(id = "drag3")
    public static WebElement cDrag3;
}
