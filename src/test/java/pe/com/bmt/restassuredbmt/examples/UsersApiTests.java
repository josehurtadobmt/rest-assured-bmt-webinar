package pe.com.bmt.restassuredbmt.examples;

import org.junit.jupiter.api.Test;
import pe.com.bmt.restassuredbmt.config.UsersApiConfig;

import static io.restassured.RestAssured.given;

public class UsersApiTests extends UsersApiConfig {

    @Test
    public void testGetAllUsers(){

        given().
        when()
                .get("users").
        then()
                .statusCode(200);
    }

    @Test
    public void testCreateNewUser(){

        String userBody = "      {\n" +
                "        \"name\": \"Test User\",\n" +
                "        \"username\": \"testuser\",\n" +
                "        \"email\": \"test@user.com\",\n" +
                "        \"address\": {\n" +
                "          \"street\": \"Has No Name\",\n" +
                "          \"suite\": \"Apt. 123\",\n" +
                "          \"city\": \"Electri\",\n" +
                "          \"zipcode\": \"54321-6789\"\n" +
                "        }\n" +
                "      }";

        given()
                .body(userBody).
                when()
                .post("users").
                then()
                .statusCode(201);
    }
}
