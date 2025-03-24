package com.demoqa.test.alertsFrameWindows;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.alertsFrameWindows.AlertsPage;

public class AlertsTest extends TestBase {
    AlertsPage alert;

    @BeforeEach
    public void precondition() {
        alert = new AlertsPage(driver);
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts().hideAd();
    }

    @Test
    @DisplayName("Verify to - Alert is appeared")
    public void alertWaitTest() {
        alert.verifyAlertWithTimer();
    }

    @Test
    @DisplayName("Verify to - 'Cancel' is displayed")
    public void cancelAlertTest() {
        alert.selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    @DisplayName("Verify to - 'Text you entered to alert is displayed")
    public void sendMessageToAlertTest() {
        alert.sendMessageToAlert("Hello World!")
                .verifyMessage("Hello World!");
    }
}
