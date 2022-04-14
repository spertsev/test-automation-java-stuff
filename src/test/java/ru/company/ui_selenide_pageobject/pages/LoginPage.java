package ru.company.ui_selenide_pageobject.pages;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private String emailFieldCssLocator = "#email";
    private String passwordFieldCssLocator = "#passwd";
    private String signInButtonCssLocator = "#SubmitLogin";

    public void signInWithCredentials(String email, String password){
        $(emailFieldCssLocator).setValue(email);
        $(passwordFieldCssLocator).setValue(password);
        $(signInButtonCssLocator).click();
    }
}
