package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 07/09/2017.
 */
public class ContactPage {

    @FindBy(id = "id_contact")
    public static WebElement contSelect;

    //#id_contact > option:nth-child(2)
    @FindBy(css = "#id_contact > option:nth-child(2)")
    public static WebElement selDept;

    @FindBy(id = "email")
    public static WebElement contEmail;

    @FindBy(id = "message")
    public static WebElement msg;

    @FindBy(xpath = "//*[@id=\"submitMessage\"]/span")
    public static WebElement sendMsg;

    //               //*[@id=\"center_column\"]/p
    //#center_column > p
    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    public static WebElement successCont;
}
