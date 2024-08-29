import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class PatchRequestTests {

    @Test
    public void testPatchMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{ \"key1\": \"patchedValue1\" }";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch");

        response.then()
                .statusCode(200)
                .body("json.key1", equalTo("patchedValue1"));
    }
}
