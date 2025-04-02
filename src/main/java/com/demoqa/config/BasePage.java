package com.demoqa.config;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public static JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver; // POM - CONSTRUCTOR IS NOT ENOUGH LIKE FOR VOM

        PageFactory.initElements(driver, this); //init the page and element
        js = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean containsText(WebElement element, String text) {
        return element.getText().contains(text);
    }

    public void scrollWithJS(int x, int y) {
        //scrolls using coordinates
        js.executeScript("window.scrollBy(" + x + "," + y + ")");

    }

    public void clickWithJS(WebElement element, int x, int y) {
        scrollWithJS(x, y);
        click(element);
    }

    public void typeWithJS(WebElement element, String text, int x, int y) {
        scrollWithJS(x, y);
        type(element, text);

    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return wait(time)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean isAlertPresent(int time) {
        Alert alert = wait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        }
        driver.switchTo().alert().accept();
        return true;
    }

    public WebDriverWait wait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void hideAd() {
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
        js.executeScript("document.getElementById('close-fixedban').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void switchToNextWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }
    public String getValue(WebElement element,String value) {
        return element.getDomAttribute(value);
    }
    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //create URL connection
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode()>=400){
                System.out.println(linkUrl + " - " + connection.getResponseMessage() + " is a broken link ");
            }else {
                System.out.println(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " - error occurred ");;
        }
    }
    public void clickWithRectangle(WebElement element,int x,int y){
        Rectangle rectangle = element.getRect();
        int xOffset = rectangle.getWidth() / x;
        int yOffset = rectangle.getHeight() / y;
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-xOffset,-yOffset).click().perform();
    }
}