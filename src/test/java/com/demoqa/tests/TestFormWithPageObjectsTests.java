package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class TestFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void succesfullFillFormTests() {
        registrationPage.openPage()
                .removeFooter()
                .setFirstName("Chandler")
                .setLastName("Bing")
                .setEmail("bing@gmail.com")
                .setGender("Male")
                .setMobileNumber("8880000097")
                .setBirthDate("8", "March", "1977")
                .setSubject("History")
                .setHobby("Music")
                .uploadPicture("1.jpg")
                .setCurrentAddress("My address")
                .setState("NCR")
                .setCity("Noida")
                .clickSubmit();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", "Chandler Bing")
                .verifyResult("Student Email", "bing@gmail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "8880000097")
                .verifyResult("Date of Birth", "8 March,1977")
                .verifyResult("Subjects", "History")
                .verifyResult("Hobbies", "Music")
                .verifyResult("Picture", "1.jpg")
                .verifyResult("Address", "My address")
                .verifyResult("State and City", "NCR Noida");
    }
}