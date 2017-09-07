package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 06/09/2017.
 */
public class SortablePage {

    @FindBy(css = "#sortable > li:nth-child(1)")
    public static WebElement sortableItem1;

    @FindBy(css = "#sortable > li:nth-child(2)")
    public static WebElement sortableItem2;
//
//    #sortable > li:nth-child(1)
//        #sortable > li:nth-child(2)
}
