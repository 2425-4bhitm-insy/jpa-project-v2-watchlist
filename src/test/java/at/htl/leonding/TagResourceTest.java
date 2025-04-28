package at.htl.leonding;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class TagResourceTest {

    @Test
    public void test_get_all() {
        given().when()
               .get("/tag/0")
               .then()
               .statusCode(200)
               .body(is("[{\"tagId\":1,\"name\":\"Action\"},{\"tagId\":51,\"name\":\"Drama\"},{\"tagId\":101,\"name\":\"Comedy\"}]"));
    }

    @Test
    public void test_get_by_id() {
        given().when()
               .get("/tag/1")
               .then()
               .statusCode(200)
               .body(is("{\"tagId\":1,\"name\":\"Action\"}"));
    }

    @Test
    public void test_create() {
        given().when()
               .contentType("application/json")
               .body("{\"name\":\"Action\"}")
               .post("/tag")
               .then()
               .statusCode(200)
               .body(is("{\"tagId\":151,\"name\":\"Action\"}"));
    }

    @Test
    public void test_delete() {
        given().when()
               .delete("/tag/101")
               .then()
               .statusCode(200)
               .body(is("true"));
    }

}

