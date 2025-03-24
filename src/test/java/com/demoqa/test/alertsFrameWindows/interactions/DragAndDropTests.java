package com.demoqa.test.alertsFrameWindows.interactions;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.interactions.DragAndDropPage;

public class DragAndDropTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getInterActions();
        new SidePanel(driver).selectDroppable().hideAd();
    }
    @Test
    public void actionDragMeTest(){
        new DragAndDropPage(driver).actionDragMe().verifyDropped("Dropped!");
    }
    @Test
    public void actionDragMeByTest(){
        new DragAndDropPage(driver).actionDragMeBy(0,30).verifyDropped("Dropped!");
    }
}
