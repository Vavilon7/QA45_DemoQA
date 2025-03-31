package pages.elements;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {


    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage enterPersonalData(String name, String email) {
        js.executeScript("document.getElementById('userName').value='" + name + "';");
        js.executeScript("document.getElementById('userEmail').value='" + email + "';");

        js.executeScript("document.getElementById('userEmail').style.border='5px solid red';");
        return this;
    }

    public TextBoxPage clickOnSubmit() {
        js.executeScript("document.querySelector('#submit').style.backGroundColor='green';");
        js.executeScript("document.querySelector('#submit').click();");
        return new TextBoxPage(driver);
    }

    public TextBoxPage refresh() {
        js.executeScript("history.go(0);");
        return new TextBoxPage(driver);
    }

    public TextBoxPage getInnerText() {
        String innerText = js.executeScript("return document.documentElement.innerText;").toString();
        System.out.println(innerText);
        System.out.println("**************************************************");
        return this;

    }

    public TextBoxPage getURL() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the page --> " + url);
        System.out.println("**************************************************");
        return this;

    }

    public TextBoxPage navigateToNewPage() {
        js.executeScript("window.location='https://ilcarro.web.app';");
        return this;
    }

    public TextBoxPage getTitleOfPage() {
        String titleOfPage = js.executeScript("return document.title;").toString();
        System.out.println(titleOfPage);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage autocomplete(String address) {
        typeWithJS(currentAddress, address, 0, 200);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        return this;
    }

    @FindBy(css = ".border>#currentAddress")
    WebElement currentAddressResult;
    @FindBy(css = ".border>#permanentAddress")
    WebElement permanentAddressResult;

    public TextBoxPage verifyAutocomplete() {
        String[] current = currentAddressResult.getText().split(":");
        String[] permanent = permanentAddressResult.getText().split(":");
        Assertions.assertEquals(permanent[1], current[1]);
        return this;
    }

    @FindBy(id = "autoCompleteMultipleInput")
    WebElement autoCompleteMultipleInput;

    public TextBoxPage keyDownEvent() {
        scrollWithJS(0, 200);
        autoCompleteMultipleInput.sendKeys("a");
        autoCompleteMultipleInput.sendKeys(Keys.DOWN, Keys.ENTER);
        return this;
    }

    @FindBy(id = "autoCompleteMultipleContainer")
    WebElement autoCompleteMultipleContainer;

    public TextBoxPage verifyText(String text) {
        Assertions.assertTrue(shouldHaveText(autoCompleteMultipleContainer, text, 5));

        return this;
    }
}
