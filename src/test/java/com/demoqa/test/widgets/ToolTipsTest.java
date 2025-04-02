package com.demoqa.test.widgets;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.widgets.ToolTipsPage;

public class ToolTipsTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectToolTips().hideAd();
    }
    @Test
    @Tag("smoke")
    public void toolTipsTest(){
        new ToolTipsPage(driver).hoverToolTips().verifyToolTips("buttonToolTip");
    }
}
