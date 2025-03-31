package pages.interactions;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;
    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        pause(1000);
        scrollWithJS(0, 200);
        new Actions(driver).dragAndDrop(dragMe, dropHere).perform();
        return this;
    }

    public DragAndDropPage verifyDropped(String text) {
        Assertions.assertTrue(containsText(dropHere, text));

        return this;
    }

    public DragAndDropPage actionDragMeBy(int x, int y) {
        pause(1000);
        scrollWithJS(0, 200);
        //get coordinates dragMe(from) and print
        int xOffSet1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffSet1 ->" + xOffSet1 + "yOffSet1 ->" + yOffset1);

        //get coordinates dropHere(to) and print
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffSet ->" + xOffset + "yOffSet ->" + yOffset);
//find difference xOffset and
        xOffset = (xOffset - xOffSet1) + x;
        yOffset=(yOffset-yOffset1)+y;
        new Actions(driver).dragAndDropBy(dragMe,xOffset,yOffset).perform();
        return this;
    }
}
