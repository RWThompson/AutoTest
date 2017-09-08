package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 08/09/2017.
 */
public class CarDealerPage {

    @FindBy(id = "postcode")
    public static WebElement postcode;

    @FindBy(id = "submit")
    public static WebElement submit;
}
