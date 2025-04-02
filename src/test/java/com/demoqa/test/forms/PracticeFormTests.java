package com.demoqa.test.forms;

import com.demoqa.config.models.Students;
import com.demoqa.config.utils.MyArgumentsProvider;
import com.demoqa.test.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;
import pages.SidePanel;
import pages.forms.PracticeFormPage;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PracticeFormTests extends TestBase {
    @BeforeEach
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideAd();
    }

    @ParameterizedTest
    @MethodSource("personalData")
    public void createAccountTest(String name,String surName,String email,String phone) {
        new PracticeFormPage(driver).enterPersonalData(Students.builder().
                        name(name).surName(surName).email(email).phone(phone).build())
                .selectGender("Male")
                .enterDate("16 Aug 1987")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sport", "Music"})
                .uploadFile("C:\\Users\\Hi-Tech\\Desktop\\istockphoto-1133819651-1024x1024.jpg.lnk")
                .inputState("NCR")
                .inputCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
    public static Stream<Arguments>personalData(){
        return Stream.of(arguments("Robert1", "Weide", "weide@gml.com", "1234567890"),
                arguments("Robert2", "Weide", "weide@gml.com", "1234567890"),
                arguments("Robert3", "Weide", "weide@gml.com", "1234567890"));
    }
   @ParameterizedTest
   @ArgumentsSource(MyArgumentsProvider.class)
    public void createAccountTestWithSelectDate(String name,String surName,String email,String phone) {
       new PracticeFormPage(driver).enterPersonalData(Students.builder().
                       name(name).surName(surName).email(email).phone(phone).build())
                .selectGender("Male")
                .selectDate("August","1987","16")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sport", "Music"})
                .uploadFile("C:\\Users\\Hi-Tech\\Desktop\\istockphoto-1133819651-1024x1024.jpg.lnk")
                .inputState("NCR")
                .inputCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void createAccountTestWithCsv(String name,String surName,String email,String phone) {
        new PracticeFormPage(driver).enterPersonalData(Students.builder().
                        name(name).surName(surName).email(email).phone(phone).build())
                .selectGender("Male")
                .selectDate("August","1987","16")
                .addSubjects(new String[]{"Math", "Chemistry"})
                .selectHobby(new String[]{"Sport", "Music"})
                .uploadFile("C:\\Users\\Hi-Tech\\Desktop\\istockphoto-1133819651-1024x1024.jpg.lnk")
                .inputState("NCR")
                .inputCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }

}

