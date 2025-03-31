package com.demoqa.test.widgets;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.TextBoxPage;

public class AutoCompleteTest2 extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getWidgets();
    }
    @Test
    public void autoCompleteTest2(){
        new SidePanel(driver).selectAutoComplete().hideAd();
        new TextBoxPage(driver).keyDownEvent().verifyText("Magenta");
    }

}
