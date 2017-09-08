package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 08/09/2017.
 */
public class SignUp {

    @FindBy(id = "customer_firstname")
    public static WebElement fname;

    @FindBy(id = "customer_lastname")
    public static WebElement sname;

    @FindBy(id = "passwd")
    public static WebElement pass;

    @FindBy(id = "address1")
    public static WebElement addLine1;

    @FindBy(id = "city")
    public static WebElement city;

    @FindBy(id = "id_state")
    public static WebElement stateSel;

    @FindBy(id = "postcode")
    public static WebElement postcode;

    @FindBy(id = "phone_mobile")
    public static WebElement mobile;

    @FindBy(css = "#submitAccount > span")
    public static WebElement submit;
}
