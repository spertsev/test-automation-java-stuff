package ru.company.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.junit.Assert;
import ru.company.ui_selenide_pageobject.pages.HomePage;
import ru.company.ui_selenide_pageobject.pages.MyAccountPage;

import java.util.List;


public class LoginSteps {

    @When("open home page")
    public void openHomePage() {
        new HomePage().open();
    }

    @And("sign in as user with following credentials")
    public void signInAsUserWithCredentials(DataTable credentialsTable) {
        List<List<String>> rows = credentialsTable.asLists(String.class);
        for (List<String> row : rows) {
            String currentEmail = row.get(0);
            String currentPassword = row.get(1);
            new HomePage()
                    .headerBar
                    .signIn()
                    .signInWithCredentials(currentEmail, currentPassword);
        }
    }

    @Then("username {string} is displayed on header bar")
    public void checkUsernameOnHeaderBar(String expectedUsername) {
        String displayedUsername = new MyAccountPage().headerBar.getUserName();
        Assert.assertEquals(expectedUsername, displayedUsername);
    }
}

