package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 08/09/2017.
 */
public class ReviewPage {

    @FindBy(id = "reviewTypeOwnerMake")
    public static WebElement make;

    @FindBy(id = "reviewTypeOwnerModel")
    public static WebElement model;

    @FindBy(id = "reviewTypeOwnerBodytype")
    public static WebElement body;

    @FindBy(id = "findReviews")
    public static WebElement search;
}
