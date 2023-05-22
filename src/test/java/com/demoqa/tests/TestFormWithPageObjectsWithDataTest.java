package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static io.qameta.allure.Allure.step;
public class TestFormWithPageObjectsWithDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void succesfullFillFormTests() {
        step("Open form", () -> {
            registrationPage.openPage()
                    .removeFooter();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(firstName)
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
        });
        step("Verify results", () -> {
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
        });
    }
}