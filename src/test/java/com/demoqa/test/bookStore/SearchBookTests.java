package com.demoqa.test.bookStore;

import com.demoqa.test.TestBase;
import data.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.bookStore.ProfilePage;

public class SearchBookTests extends TestBase {
    @BeforeEach
    public void precondition(){
        new HomePage(driver).getBookStore();
    }
    @Test
    @DisplayName("Verify BookName contains- 'Speaking'")
    @Tag("smoke")
    public void searchBookPositiveTest(){
        new ProfilePage(driver).enterBookName(UserData.BOOK_NAME).verifyBookName(UserData.BOOK_NAME);
    }
}
