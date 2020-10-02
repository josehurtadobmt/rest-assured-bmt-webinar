package pe.com.bmt.restassuredbmt.examples;

import org.junit.jupiter.api.Test;
import pe.com.bmt.restassuredbmt.config.UsersApiConfig;

import static io.restassured.RestAssured.given;

public class UsersApi2Tests extends UsersApiConfig {


    @Test
    public void test4ValidateUserData(){

        given()
                .pathParam("id",1).
                when()
                .get("users/{id}").
                then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("user_schema.json"))
                .body("id", equalTo(1))
                .body("name", equalTo("Leanne Graham"))
                .body("username", equalTo("Bret"))
                .body("email", equalTo("Sincere@april.biz"))
                .body("address.street", equalTo("Kulas Light"));
    }

}
