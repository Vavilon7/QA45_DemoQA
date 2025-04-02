package com.demoqa.test.alertsFrameWindows.elements;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.elements.UploadPage;

public class UploadTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUploadAndDownload().hideAd();
    }
    @Test
    public void performKeyWithRobotTest(){
        new UploadPage(driver).performKeyEvent().verifyPath("C:\\Users\\Hi-Tech\\D1.txt");
    }
    @Test
    public void performMouseEvent(){
        new UploadPage(driver).performMouseEvent();
    }
}
