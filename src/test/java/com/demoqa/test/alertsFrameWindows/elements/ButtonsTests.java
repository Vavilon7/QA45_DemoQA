package com.demoqa.test.alertsFrameWindows.elements;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.ButtonsPage;

public class ButtonsTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectButtons().hideAd();
    }
    @Test
    public void doubleClickTest(){
        new ButtonsPage(driver).doubleClick().verifyDoubleClick("You have done a double click");
    }
    @Test
    public void rightClickTest(){
        new ButtonsPage(driver).rightClick().verifyRigthClick("You have done a right click");
    }
}
