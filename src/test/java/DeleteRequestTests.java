import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class DeleteRequestTests {

    @Test
    public void testDeleteMethod() {
        RestAssured.baseURI = "https://postman-echo.com";

        Response response = RestAssured.given()
                .when()
                .delete("/delete");

        response.then()
                .statusCode(200)
                .body("json", hasKey("message"));
    }
}
