package ru.company.ui_selenide_pageobject.pages;

import com.codeborne.selenide.Selenide;

public class HomePage {

    public HeaderBar headerBar;

    public HomePage() {
        headerBar = new HeaderBar();
    }

    public HomePage open(){
        Selenide.open("/");
        return this;
    }


}
