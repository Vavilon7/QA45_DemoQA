package pages.alertsFrameWindows;

import config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public FramePage returnListOfIframes() {
        //by finding all web elements using iframe tag
        System.out.println("The total numbers of iframes are " + iframes.size());

        //by executing JS
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("The total numbers of iframes are " + numberOfIframes);
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public FramePage verifyIframeByTitle(String title) {
        Assertions.assertTrue(shouldHaveText(sampleHeading,title,1));
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramePage switchToIframeById() {
        driver.switchTo().frame(frame1);
        return this;
    }

    public FramePage returnToMainPage() {
        driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement title;

    public FramePage verifyMainPageByTitle(String text) {
        Assertions.assertTrue(containsText(title,text));
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public FramePage handleNestedIframes() {
        //switch to parent iframe
        driver.switchTo().frame(frame1);
        //get text from parent frame
        System.out.println("Iframe is " + body.getText());
        //number of iframes in parent frame
        System.out.println("Number of iframes inside parent iframe is " + iframes.size());
        //switch to child iframe
        driver.switchTo().frame(0);
        //get text from child frame
        System.out.println("Iframe is " + body.getText());
        //  driver.switchTo().parentFrame();
        //switch to main page
        driver.switchTo().defaultContent();
        //get title of main page
        System.out.println("Title of main page is " + title.getText());
        return this;
    }
}