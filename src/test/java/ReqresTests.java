import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ReqresTests extends TestBase {

    @Test
    void getUsersList() {
        given()
                .header("x-api-key", API_KEY)
                .log().uri()
        .when()
                .get("/api/users?page=2")
        .then()
                .log().body()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("data", hasSize(6));
    }

    @Test
    void getSingleUser() {
        given()
                .header("x-api-key", API_KEY)
                .log().uri()
                .when()
                .get("/api/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", containsString("@reqres.in"));
    }

    @Test
    void createUser() {
        String body = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"leader\"\n" +
                "}";

        given()
                .header("x-api-key", API_KEY)
                .contentType("application/json")
                .body(body)
                .log().body()
        .when()
                .post("/api/users")
        .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }

    @Test
    void updateUser() {
        String body = "{\n" +
                "  \"name\": \"morpheus\",\n" +
                "  \"job\": \"zion resident\"\n" +
                "}";

        given()
                .header("x-api-key", API_KEY)
                .contentType("application/json")
                .body(body)
                .log().body()
                .when()
                .put("/api/users/2")
                .then()
                .log().body()
                .statusCode(200)
                .body("job", equalTo("zion resident"))
                .body("updatedAt", notNullValue());
    }

    @Test
    void deleteUser() {
        given()
                .header("x-api-key", API_KEY)
                .log().uri()
                .when()
                .delete("/api/users/2")
                .then()
                .log().body()
                .statusCode(204);
    }







}
