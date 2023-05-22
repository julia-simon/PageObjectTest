package com.demoqa.tests;

import com.github.javafaker.Faker;

public class TestData {
    public static Faker faker = new Faker();


    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            genderUser = faker.options().option("Male", "Female", "Other"),
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            subjects = faker.options().option("Hindi", "Maths", "Accounting", "Chemistry", "Physics", "Biology", "Computer Science", "History", "English"),
            year = String.valueOf(faker.number().numberBetween(1990, 2023)),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            picture = "1.jpg",
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = cityUser();

    public static String cityUser() {
        String varCity;
        switch (state) {
            case "NCR":
                varCity = faker.options().option("Delhi", "Gurgaon", "Noida");
                return varCity;

            case "Uttar Pradesh":
                varCity = faker.options().option("Agra", "Lucknow", "Merrut");
                return varCity;

            case "Haryana":
                varCity = faker.options().option("Karnal", "Panipat");
                return varCity;

            case "Rajasthan":
                varCity = faker.options().option("Jaipur", "Jaiselmer");
                return varCity;

            default:
                return "";
        }
    }
}