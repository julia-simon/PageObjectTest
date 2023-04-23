package com.demoqa.Pages.Components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    // Selenide elements / locator / etc
    SelenideElement modalDialog = $(".modal-dialog"),
                    headerModal = $("#example-modal-sizes-title-lg"),
                    tableResult = $(".table-responsive");


    // Actions

    public void verifyModalAppears() {
        modalDialog.should(appear);
        headerModal.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        tableResult.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
