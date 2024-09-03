import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostFromDataTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://api.example.com"; // Замените на свой базовый URL
    }

    @Test
    public void testPostFromData() {
        String requestBody = "{ \"key1\": \"value1\", \"key2\": \"value2\" }";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/from-data-endpoint") // Замените на свой эндпоинт
                .then()
                .statusCode(201)
                .extract().response();

        assertEquals("expectedValue1", response.jsonPath().getString("field1"));
        assertEquals("expectedValue2", response.jsonPath().getString("field2"));
        assertEquals("expectedValue3", response.jsonPath().getString("field3"));
    }
}