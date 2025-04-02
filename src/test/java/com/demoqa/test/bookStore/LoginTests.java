package com.demoqa.test.bookStore;

import com.demoqa.test.TestBase;
import data.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SidePanel;
import pages.bookStore.LoginPage;

public class LoginTests extends TestBase {
    @BeforeEach
    public void precondition() {
        new HomePage(driver).getBookStore();
        new SidePanel(driver).selectLogin();
    }

    @RepeatedTest(value = 3, failureThreshold = 1, name = "{displayName}{currentRepetition}/{totalRepetitions}")
    @DisplayName("We try to get error")
    public void loginNegativeTest() {
        new LoginPage(driver).enterLoginData("NNN", UserData.PASSWORD)
                .clickOnLoginButton()
                .verifyUserName(UserData.USER_NAME);
    }

    @Test
    @Tag("parameters")
    @DisplayName("Verify to - 'User name 'neuer' is displayed '")
    public void loginPositiveTest() {
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        new LoginPage(driver).enterLoginData(UserData.USER_NAME, UserData.PASSWORD)
                .clickOnLoginButton()
                .verifyUserName(UserData.USER_NAME);
    }
}

