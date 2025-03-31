package pages.elements;

import com.demoqa.config.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksImagesPage extends BasePage {
    public LinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a")
    List<WebElement> allLinks;

    public LinksImagesPage getAllLinks() {
        String url = "";
        System.out.println("Total links on the page are " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
            System.out.println("**************************************");
        }
        return this;
    }

    public LinksImagesPage verifyBrokenLinks() {
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getDomAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public LinksImagesPage verifyBrokenImages() {
        System.out.println("We have " + images.size() + " images ");
        for (int i = 0; i < images.size(); i++) {
            WebElement element=images.get(i);
            String imagesUrl = element.getAttribute("src");
            verifyLinks(imagesUrl);

            try {
                boolean imageDisplayed = (Boolean)js.
                        executeScript(" return ( typeof arguments[0].naturalWidth!=undefined && arguments[0].naturalWidth>0);",element);
                if(imageDisplayed){
                    System.out.println("DISPLAY - OK");
                    System.out.println("************************************");
                }else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("************************************");
                }
            } catch (Exception e) {
                System.out.println("ERROR OCCURRED");
            }
        }

        return this;
    }
}

