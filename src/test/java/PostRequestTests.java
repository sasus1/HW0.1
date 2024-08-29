import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class PostRequestTests {

    @Test
    public void testPostMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"New Item\", \"status\": \"created\" }")
                .when()
                .post("/post");

        response.then()
                .statusCode(200)
                .body("json.name", equalTo("New Item"))
                .body("json.status", equalTo("created"));
    }
}
