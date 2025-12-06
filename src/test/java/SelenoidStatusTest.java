import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SelenoidStatusTest {

    @Test
    void checkTotalIs5() {
        given()
                .log().all() // логируем запрос
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().body()      // логируем ответ
                .statusCode(200)   // проверяем статус
                .body("total", equalTo(5)); // проверяем поле total
    }

    @Test
    void checkTotalWithoutLog() {
        given()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(5));
    }

}
