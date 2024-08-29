import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class GetRequestTests {

    @Test
    public void testGetMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = RestAssured.given()
                .when()
                .get("/get");

        response.then()
                .statusCode(200)
                .body("args", hasKey("key1"))
                .body("args.key1", equalTo("expectedValue1"));
    }
}