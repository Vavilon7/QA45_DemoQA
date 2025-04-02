package com.demoqa.config;
import com.demoqa.config.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import java.time.Duration;
public class ApplicationManager {
    String browser;
    public WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver startTest() {
        switch (browser){
            case "chrome"->driver=new ChromeDriver();
            case "firefox"->driver=new FirefoxDriver();
            case "edge"->driver=new EdgeDriver();
            case "safari"->driver=new SafariDriver();

        }
        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    public void stopTest() {
        driver.quit();
    }
}
