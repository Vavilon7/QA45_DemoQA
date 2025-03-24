package pages.alertsFrameWindows;

import config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage verifyAlertWithTimer() {
        click(timerAlertButton);

        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage selectResult(String result) {
        click(confirmButton);

        if (result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String result) {
        Assertions.assertTrue(containsText(confirmResult,result));
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String text) {
        clickWithJS(promtButton,0,200);

        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
        }
        return this;
    }

    public AlertsPage verifyMessage(String message) {
        Assertions.assertTrue(isTextInAlertPresent(30,message));
        return this;
    }

    public boolean isTextInAlertPresent(int time, String message) {
        Alert alert = wait(time).until(ExpectedConditions.alertIsPresent());

        if (alert == null) {
            return false;
        }
        driver.switchTo().alert().getText().contains(message);
        alert.accept();
        return true;
    }
}