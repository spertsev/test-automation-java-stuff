package ru.company.ui_selenide_pageobject.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.company.ui_selenide_pageobject.configs.BaseTest;
import ru.company.ui_selenide_pageobject.configs.TestUsersData;
import ru.company.ui_selenide_pageobject.pages.HomePage;
import ru.company.ui_selenide_pageobject.pages.MyAccountPage;


public class LoginTest extends BaseTest {
    @Test
    public void openWebsiteAndSignInAsUser() {
        new HomePage()
                .open()
                .headerBar
                .signIn()
                .signInWithCredentials(TestUsersData.USER1_EMAIL, TestUsersData.USER1_PASSWORD);

        MyAccountPage myAccountPage = new MyAccountPage();
        Assertions.assertEquals(TestUsersData.USER1_FULLNAME, myAccountPage.headerBar.getUserName());
    }
}

