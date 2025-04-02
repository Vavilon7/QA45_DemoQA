package com.demoqa.config.utils;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("Something went wrong!");
        logger.error("=========================================");
        logger.error("Method - {}", method.toString());
        logger.error("=========================================");
        logger.error("Target -{}", target.toString());
        logger.error("=========================================");
        logger.error("Exception -{}", e.getTargetException());
        int i =new Random().nextInt(1000)+1000;
        String link="screenshots/screen_"+ i + ".png";
        WebDriver driver = (ChromeDriver)target;
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        logger.info("Open url -{}",url);
    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        logger.info("Page title - {}", result);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
       logger.info("We find elements {}", result.size());
    }

    @Override
    public void beforeClick(WebElement element) {
       logger.info("We have to click element -{}",element.toString());
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        logger.info("We fill in {} with value -{}",element.toString(),keysToSend);
    }

    @Override
    public void beforeAlert(WebDriver.TargetLocator targetLocator) {
        logger.info("We have alert with text - '{}'",targetLocator.alert().getText());
    }
}
