package com.demoqa.test.widgets;

import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.widgets.SliderPage;

public class SliderTest extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSlider().hideAd();
    }
    @Test
    public void sliderTest(){
        new SliderPage(driver).moveSliderToHorizontalDirection().verifySliderValue("100");
    }
}
