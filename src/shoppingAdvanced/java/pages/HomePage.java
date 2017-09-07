package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 07/09/2017.
 */
public class HomePage {

    @FindBy(css = "#homefeatured > li:nth-child(2) > div > div.left-block > div > a.product_img_link > img")
    public static WebElement item;

    @FindBy(css = "#homefeatured > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    public static WebElement addButton;

    @FindBy(css = ".cross")
    public static WebElement exitPopUp;

    @FindBy(className = "ajax_cart_quantity")
    public static WebElement productsInCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public static WebElement proceed;

    @FindBy(css = "#add_to_cart > button > span")
    public static WebElement addProduct;

    @FindBy(xpath = "//*[@id=\"social_block\"]/ul/li[3]/a")
    public static WebElement ytLink;

    @FindBy(xpath = "//*[@id=\"columns\"]/p")
    public static WebElement success;

    @FindBy(css = "#newsletter-input")
    public static WebElement email;

    @FindBy(css = "#newsletter_block_left > div > form > div > button")
    public static WebElement submit;

    @FindBy(css = "#contact-link > a")
    public static WebElement contactLink;
}
