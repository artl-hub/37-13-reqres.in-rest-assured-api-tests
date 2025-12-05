import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    protected static final String BASE_URL = "https://reqres.in";
    protected static final String API_KEY = "api_key";


    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE_URL;
    }
}
