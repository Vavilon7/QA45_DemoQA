package com.demoqa.test.bookStore;

import com.demoqa.test.TestBase;
import data.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.LoginPage;

public class LoginTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }
    @Test
    @DisplayName("Verify to - 'neuer' is displayed ")
    public void loginPositiveTest(){
        new LoginPage(driver).enterLoginData(UserData.USER_NAME,UserData.PASSWORD)
                .clickOnLoginButton()
                .verifyUserName(UserData.USER_NAME);
    }
}

