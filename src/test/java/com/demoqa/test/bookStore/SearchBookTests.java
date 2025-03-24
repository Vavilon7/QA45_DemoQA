package com.demoqa.test.bookStore;

import com.demoqa.test.TestBase;
import data.UserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    public void searchBookPositiveTest(){
        new ProfilePage(driver).enterBookName(UserData.BOOK_NAME).verifyBookName(UserData.BOOK_NAME);
    }
}
