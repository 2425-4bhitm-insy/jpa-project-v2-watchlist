package at.htl.leonding;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {
    @Test
    public void test_get_all() {
        given().when()
                .get("/person/1")
                .then()
                .statusCode(200)
                .body(is("{\"personId\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"}"));
    }
    @Test
    public void test_create() {
        given().when()
                .get("/media/1")
                .then()
                .statusCode(200)
                .body(is(""));
    }
}
