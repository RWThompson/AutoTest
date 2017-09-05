package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 05/09/2017.
 */
public class login {

    @FindBy(name = "username")
    public static WebElement userEle;

    @FindBy(name = "password")
    public static WebElement passEle;

    @FindBy(name = "FormsButton2")
    public static WebElement butEle;
}
