import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected static final String BASE_URL = "https://reqres.in";
    protected static final String BASE_PATH = "/api";
    protected static final String API_KEY = "reqres_3f7eee13f9114794996a0920fb543c12";


    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.basePath = BASE_PATH;
    }
}
