package webPages;

import com.oracle.jrockit.jfr.EventDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 08/09/2017.
 */
public class AutoTraderHome {

    @FindBy(id = "postcode")
    public static WebElement postcode;

    @FindBy(id = "radius")
    public static WebElement distance;

    @FindBy(id = "searchVehiclesMake")
    public static WebElement make;

    @FindBy(id = "searchVehiclesModel")
    public static WebElement model;

    @FindBy(css = "#search > span")
    public static WebElement searchBut;

    @FindBy(css = "#home > div.white-footer > footer > div > nav:nth-child(4) > ul > li.footer__nav-listing--3 > a")
    public static WebElement ytLink;

    @FindBy(css = "#js-editorial-content > section.sell__nav > div > form > input:nth-child(1)")
    public static WebElement sellReg;

    @FindBy(css = "#js-editorial-content > section.sell__nav > div > form > input:nth-child(2)")
    public static WebElement sellMileage;

    @FindBy(css = "#js-editorial-content > section.sell__nav > div > form > button")
    public static WebElement createSell;

    @FindBy(css = "#js-header-nav > ul > li.test-header__nav-listing.u-float-right > div.is-not-signed-in > a")
    public static WebElement signIn;
}
