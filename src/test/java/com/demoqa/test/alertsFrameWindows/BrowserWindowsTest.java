package com.demoqa.test.alertsFrameWindows;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.BrowserWindowsPage;

public class BrowserWindowsTest extends TestBase {
  @BeforeEach
  public void precondition() {
       new HomePage(driver).getAlertsFrameWindows();
       new SidePanel(driver).selectBrowserWindows().hideAd();
   }

    @Test
    public void switchToNewTabTest() {
        new BrowserWindowsPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }
}