package com.demoqa.test.alertsFrameWindows.elements;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.TextBoxPage;

public class AutoCompleteTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getElements();
    }
    @Test
    public void autoCompleteTest(){
        new SidePanel(driver).selectTextBox().hideAd();
        new TextBoxPage(driver).autocomplete("Vavilon").clickOnSubmit().verifyAutocomplete();
    }


}
