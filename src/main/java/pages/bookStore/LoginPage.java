package pages.bookStore;

import config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userNameField;
    @FindBy(id = "password")
    WebElement passwordField;

    public LoginPage enterLoginData(String userName, String password) {
        typeWithJS(userNameField,userName, 0,800);
        type(passwordField,password);
        return this;
    }
    @FindBy(id = "login")
    WebElement loginButton;
    public ProfilePage clickOnLoginButton() {
        click(loginButton);
        return new ProfilePage(driver);
    }
}
