package pages.elements;

import config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        pause(1000);
        scrollWithJS(0, 200);
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;

    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage verifyDoubleClick(String text) {
        Assertions.assertTrue(containsText(doubleClickMessage, text));

        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClick() {
        pause(1000);
        scrollWithJS(0, 300);
        new Actions(driver).contextClick(rightClickBtn).perform();

        return this;
    }
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;
    public ButtonsPage verifyRigthClick(String text) {
        Assertions.assertTrue(containsText(rightClickMessage,text));
        return this;
    }
}
