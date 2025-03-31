package com.demoqa.test.alertsFrameWindows.elements;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.LinksImagesPage;

public class LinksImagesTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getElements();
    }
    @Test
    public void getAllLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksImagesPage(driver).getAllLinks();
    }
    @Test
    public void getBrokenLinksTest(){
        new SidePanel(driver).selectBrokenLinkImages();
        new LinksImagesPage(driver).verifyBrokenLinks();
    }
    @Test
    public void getBrokenImages(){
        new SidePanel(driver).selectBrokenLinkImages();
        new LinksImagesPage(driver).verifyBrokenImages();
    }
}
