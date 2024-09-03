import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetRequestWoopsTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://api.example.com"; // Зменить на сой базовый URL
    }

    @Test
    public void testGetRequestWoops() {
        Response response = given()
                .when()
                .get("/woops-endpoint") //Вписать свой эндпоинт
                .then()
                .statusCode(200)
                .extract().response();

        assertEquals("expectedValue1", response.jsonPath().getString("field1"));
        assertEquals("expectedValue2", response.jsonPath().getString("field2"));
        assertEquals("expectedValue3", response.jsonPath().getString("field3"));
    }
}
