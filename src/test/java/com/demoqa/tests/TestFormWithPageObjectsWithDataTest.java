package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;


public class TestFormWithPageObjectsWithDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void succesfullFillFormTests() {
        registrationPage.openPage()
                .removeFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(genderUser)
                .setMobileNumber(mobileNumber)
                .setBirthDate(day, month, year)
                .setSubject(subjects)
                .setHobby(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", genderUser)
                .verifyResult("Mobile", mobileNumber)
                .verifyResult("Date of Birth", String.format("%s %s,%s", day, month, year))
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}