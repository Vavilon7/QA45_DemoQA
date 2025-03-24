package com.demoqa.test.widgets;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.widgets.MenuPage;

public class MenuTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).getMenu().hideAd();
    }
    @Test
    public void moveToMenuTest(){
        new MenuPage(driver).moveToSubMenu().verifySubMenu();
    }
}
