package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 06/09/2017.
 */
public class Selectable {

    @FindBy(css = "#selectable > li:nth-child(1)")
    public static WebElement selectItem1;
}
