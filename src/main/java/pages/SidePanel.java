package pages;

import com.demoqa.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.alertsFrameWindows.AlertsPage;
import pages.alertsFrameWindows.BrowserWindowsPage;
import pages.alertsFrameWindows.FramePage;
import pages.bookStore.LoginPage;
import pages.elements.ButtonsPage;
import pages.elements.LinksImagesPage;
import pages.elements.TextBoxPage;
import pages.forms.PracticeFormPage;
import pages.interactions.DragAndDropPage;
import pages.widgets.MenuPage;
import pages.widgets.SelectMenuPage;
import pages.widgets.SliderPage;
import pages.widgets.ToolTipsPage;

public class SidePanel extends BasePage {
    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[.='Login']")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJS(login,0,300);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//*[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJS(alerts,0,300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//*[.='Frames']")
    WebElement frames;

    public FramePage selectFrames() {
        clickWithJS(frames,0,300);
        return new FramePage(driver);
    }

    @FindBy(xpath = "//*[.='Nested Frames']")
    WebElement nestedFrames;

    public FramePage selectNestedFrames() {
        clickWithJS(nestedFrames,0,400);
        return new FramePage(driver);
    }
    @FindBy(xpath = "//*[.='Browser Windows']")
    WebElement browserWindows;
    public BrowserWindowsPage selectBrowserWindows() {
        clickWithJS(browserWindows, 0, 300);
        return new BrowserWindowsPage(driver);
    }
    @FindBy(xpath = "//*[.='Select Menu']")
    WebElement selectMenu;
    public SelectMenuPage selectSelectMenu() {
        clickWithJS(selectMenu,0,700);
        return new SelectMenuPage(driver);
    }
    @FindBy(xpath = "//*[.='Menu']")
    WebElement menu;
    public MenuPage getMenu() {
        clickWithJS(menu,0,700);
        return new MenuPage(driver);

    }
    @FindBy(xpath = "//*[.='Slider']")
    WebElement slider;
    public SliderPage selectSlider() {
        clickWithJS(slider,0,500);
        return new SliderPage(driver);
    }
    @FindBy(xpath = "//*[.='Droppable']")
    WebElement droppable;
    public DragAndDropPage selectDroppable() {
        clickWithJS(droppable,0,500);
        return new DragAndDropPage(driver);
    }
    @FindBy(xpath = "//*[.='Tool Tips']")
    WebElement toolTips;
    public ToolTipsPage selectToolTips() {
        clickWithJS(toolTips,0,700);
        return new ToolTipsPage(driver);
    }
    @FindBy(xpath = "//*[.='Buttons']")
    WebElement buttons;
    public ButtonsPage selectButtons() {
        clickWithJS(buttons,0,100);
        return new ButtonsPage(driver);
    }
    @FindBy(xpath = "//*[.='Text Box']")
    WebElement textBox;
    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }
    @FindBy(xpath = "//*[.='Links']")
    WebElement links;
    public LinksImagesPage selectLinks() {
        clickWithJS(links,0,200);
        return new LinksImagesPage(driver);
    }
    @FindBy(xpath = "//*[.='Broken Links - Images']")
    WebElement brokenLinksImages;
    public LinksImagesPage selectBrokenLinkImages() {
        clickWithJS(brokenLinksImages,0,200);
        return new LinksImagesPage(driver);
    }
    @FindBy(xpath = "//*[.='Auto Complete']")
    WebElement autoComplete;
    public TextBoxPage selectAutoComplete() {
        clickWithJS(autoComplete,0,400);
        return new TextBoxPage(driver);
    }
    @FindBy(xpath = "//*[.='Practice Form']")
    WebElement practiceForm;
    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }
}