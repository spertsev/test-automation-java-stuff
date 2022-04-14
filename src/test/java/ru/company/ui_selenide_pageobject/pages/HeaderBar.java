package ru.company.ui_selenide_pageobject.pages;

import static com.codeborne.selenide.Selenide.$;

public class HeaderBar {
    private String signInCssLocator = "a.login";
    private String userAccountCssLocator = ".account";

    public LoginPage signIn() {
        $(signInCssLocator).click();
        return new LoginPage();
    }

    public String getUserName(){
        return $(userAccountCssLocator).getText();
    }
}
