package com.demoqa.test.alertsFrameWindows;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.FramePage;

public class IframesTests extends TestBase {
    @BeforeEach
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
    }

    @Test
    @DisplayName("Verify to - Title 'This is a sample page' is displayed")
    public void iframeTest() {
        new SidePanel(driver).selectFrames();
        new FramePage(driver).returnListOfIframes()
                .switchToIframeByIndex(1)
                .verifyIframeByTitle("This is a sample page");
    }

    @Test
    @DisplayName("Find iframe by locator and return to Main page")
    public void findIframeByIdTest() {
        new SidePanel(driver).selectFrames();
        new FramePage(driver).switchToIframeById()
                .verifyIframeByTitle("This is a sample page")
                .returnToMainPage()
                .verifyMainPageByTitle("Frames");
    }

    @Test
    @DisplayName("Handle Nested Iframes")
    public void nestedIframesTest() {
        new SidePanel(driver).selectNestedFrames();
        new FramePage(driver).handleNestedIframes();
    }
}