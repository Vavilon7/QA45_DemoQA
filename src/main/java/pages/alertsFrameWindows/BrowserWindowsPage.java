package pages.alertsFrameWindows;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;
    public BrowserWindowsPage switchToNewTab(int index) {
        click(tabButton);

        switchToNextWindow(index);
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement sampleHeading;

    public BrowserWindowsPage verifyNewTabTitle(String title) {
        Assertions.assertTrue(shouldHaveText(sampleHeading, title, 5));
        return this;

    }
}
