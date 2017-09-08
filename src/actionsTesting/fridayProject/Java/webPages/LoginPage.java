package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 08/09/2017.
 */
public class LoginPage {

    @FindBy(id = "signin-email")
    public static WebElement email;

    @FindBy(id = "signin-password")
    public static WebElement pass;

    @FindBy(id = "signInSubmit")
    public static WebElement submit;
}
