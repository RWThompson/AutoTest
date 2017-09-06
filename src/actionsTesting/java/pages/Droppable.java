package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 06/09/2017.
 */
public class Droppable {

    @FindBy(id = "draggableview")
    public static WebElement defDrop;

    @FindBy(css = "#droppableview > p")
    public static WebElement defDropTargetText;

    @FindBy(id = "droppableview")
    public static WebElement defDropTarget;

    @FindBy(css = "#ui-id-2")
    public static WebElement acceptTab;

    @FindBy(id = "draggable-nonvalid")
    public static WebElement nonValid;

    @FindBy(id = "draggableaccept")
    public static WebElement valid;

    @FindBy(id = "droppableaccept")
    public static WebElement acceptTarget;

    @FindBy(css = "#droppableaccept > p")
    public static WebElement acceptText;
}
