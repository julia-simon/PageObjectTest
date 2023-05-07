package com.demoqa.pages.components;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    // Selenide elements / locator / etc

    SelenideElement mouthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        mouthSelect.selectOption(month);
        yearSelect.selectOption(year);
        String dayPickerLocator = format(".react-datepicker__day--0%s:not(.react-datapicker__day--outside-,month)", day);
        $(dayPickerLocator).click();
    }
}





