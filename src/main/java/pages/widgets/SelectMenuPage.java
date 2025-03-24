package pages.widgets;

import config.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);
        return this;
    }

    public SelectMenuPage verifyColor() {
        String firstOptions = new Select(oldSelectMenu).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(oldSelectMenu, firstOptions, 5));
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;
    @FindBy(tagName = "html")
    WebElement space;

    public SelectMenuPage multiSelect(String[] colors) {
        for (String text : colors) {
            inputSelect.sendKeys(text);
            inputSelect.sendKeys(Keys.ENTER);
        }
        click(space);
        return this;
    }

    public SelectMenuPage verifySelectedCarByRgb(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);
        //System.out.println(selectedCar.getCssValue("background-color"));
        String rgbFormat = selectedCar.getCssValue("background-color");
        Assertions.assertTrue(rgbFormat.contains(color));
        return this;
    }

    public SelectMenuPage verifySelectedCarByHex(String car, String color) {
        WebElement selectedCar = driver.findElement(By.cssSelector("[value='" + car + "']"));
        click(selectedCar);

        String rgbFormat = selectedCar.getCssValue("background-color");
        String hexColor = Color.fromString(rgbFormat).asHex();
        // System.out.println(hexColor);
        Assertions.assertTrue(hexColor.contains(color));
        return this;
    }

    @FindBy(id = "cars")
    WebElement car;

    public SelectMenuPage standardMultiSelect(String[] colors) {
        Select multi =new Select(car);
        for (int i=0;i <colors.length; i ++){
            multi.selectByVisibleText(colors[i]);
        }
        List<WebElement> options = multi.getAllSelectedOptions();
        for (WebElement element: options)
            System.out.println(element.getText() + "--> multi");

        return this;
    }
}
