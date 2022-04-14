package ru.company.api_rest_assured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;


/**
 * This class contains Junit 5 tests of the https://reqres.in API
 */
public class ReqresTest {
    private final String REQRES_URL = "https://reqres.in";

    @Test
    public void usersPathShouldResponseWith200() {
        given()
                .when().get(REQRES_URL + "/api/users?page=2")
                .then().statusCode(200);
    }

    @Test
    public void usersEmailAddressesShouldEndWithCorrectDomain() {
        List<ReqresUser> users = given().contentType(ContentType.JSON)
                .when().get(REQRES_URL + "/api/users?page=2")
                .then().log().all().extract().body().jsonPath().getList("data", ReqresUser.class);

        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }

}
