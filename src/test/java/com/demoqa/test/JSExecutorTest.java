package com.demoqa.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.TextBoxPage;

public class JSExecutorTest extends TestBase{
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox().hideAd();
    }
    @Test
    public void jsExecutorTest(){
        new TextBoxPage(driver).enterPersonalData("Ivan Ivanov","sghdjfvk@gmail.com").
                clickOnSubmit().getInnerText().refresh().getURL().navigateToNewPage().getTitleOfPage();
    }
}
