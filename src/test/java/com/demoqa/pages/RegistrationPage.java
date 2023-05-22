package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    // Selenide elements / locator / etc
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateAndCity = $(".css-26l3qy-menu"),
            submitButton = $("#submit");

    // Actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public RegistrationPage removeFooter() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setMobileNumber(String value) {
        userNumber.setValue(value);

        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.click();
        stateAndCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateAndCity.$(byText(value)).click();

        return this;
    }
    public RegistrationPage clickSubmit() {
        submitButton.click();

        return this;
    }
    public RegistrationPage verifyRegistrationResultModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);

        return this;
    }
}