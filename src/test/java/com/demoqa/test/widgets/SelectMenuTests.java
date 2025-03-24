package com.demoqa.test.widgets;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.widgets.SelectMenuPage;

public class SelectMenuTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSelectMenu().hideAd();
    }

    @Test
    public void selectOldStyleTest(){
        new SelectMenuPage(driver).selectOldStyle("Blue").verifyColor();
    }

    @Test
    public void multiSelectTest(){
        new SelectMenuPage(driver).multiSelect(new String[]{"Red","Green"});
    }

    @Test
    public void standardMultiSelect(){
        new SelectMenuPage(driver).verifySelectedCarByHex("volvo","#1967d2");
    }

    @Test
    public void standardMultiSelect2(){
        new SelectMenuPage(driver).standardMultiSelect(new String[]{"Volvo" ,"Audi"});
    }
}
