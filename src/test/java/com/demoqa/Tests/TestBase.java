package com.demoqa.Tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.Pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "Chrome";
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy="eager";
    }
}