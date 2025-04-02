package pages.elements;

import com.demoqa.config.BasePage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEvent() {
        pause(1000);
        scrollWithJS(0,200);
        clickWithRectangle(uploadFile,3,5);

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //press SHIFT key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(500);
        //press d(upper case as SHIFT key is pressed)
        robot.keyPress(KeyEvent.VK_D);
        //release SHIFT key
        robot.keyRelease(KeyEvent.VK_SHIFT);
        //press 1, ., t, x, t
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        //press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage verifyPath(String path) {
        Assertions.assertTrue(shouldHaveText(uploadedFilePath,path,5));
        return this;
    }

    public UploadPage performMouseEvent() {
        pause(1000);
        scrollWithJS(0,200);
        clickWithRectangle(uploadFile,3,5);

        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //find x and y coordinates
        //get windows size
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimension x and y --> " + dimension.getWidth() + " X " + dimension.getHeight());

//        pause(10000);
//        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
//        Point location = pointerInfo.getLocation();
//        int x = (int) location.getX();
//        int y = (int) location.getY();
//        System.out.println(y + " **** " + x);
        //get point of file location
        int x = dimension.getWidth() / 2 + 500;
        int y = dimension.getHeight() / 2;
        robot.mouseMove(x,y);
        pause(1000);
        //click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        //press ENTER key
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}