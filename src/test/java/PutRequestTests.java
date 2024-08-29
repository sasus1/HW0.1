import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class PutRequestTests {

    @Test
    public void testPutMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{ \"key1\": \"updatedValue1\", \"key2\": \"updatedValue2\" }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put");

        response.then()
                .statusCode(200)
                .body("json.key1", equalTo("updatedValue1"))
                .body("json.key2", equalTo("updatedValue2"));
    }
}
