package pages.bookStore;

import com.demoqa.config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName-value")
    WebElement userNameValue;
    public ProfilePage verifyUserName(String userName) {
        Assertions.assertTrue(containsText(userNameValue,userName));
        return this;
    }
    @FindBy(id = "searchBox")
    WebElement searchBox;
    public ProfilePage enterBookName(String text) {
        type(searchBox,text);
        return this;
    }
    @FindBy(css = ".mr-2>a")
    WebElement nameOfBook;
    public ProfilePage verifyBookName(String text) {
        Assertions.assertTrue(shouldHaveText(nameOfBook,text,10));
        return this;
    }

}
