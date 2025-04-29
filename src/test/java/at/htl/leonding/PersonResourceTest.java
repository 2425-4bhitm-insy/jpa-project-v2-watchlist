package at.htl.leonding;

import at.htl.leonding.entities.PersonType;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {
    @Test
    public void test_get_all() {
        given().when()
                .get("/person/0")
                .then()
                .statusCode(200)
                .body(is("[{\"personId\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"},{\"personId\":51,\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"email\":\"jane.smith@example.com\"},{\"personId\":101,\"firstName\":\"Alice\",\"lastName\":\"Johnson\",\"email\":\"alice.johnson@example.com\"}]"));
    }
    @Test
    public void test_create() {
        given().when()
               .contentType("application/json")
               .body("{\"duration\":0,\"releaseDate\":null,\"rating\":0,\"edition\":0,\"name\":\"Action\",\"description\":null,\"mediaType\":null,\"tags\":[]}")
               .post("/person")
               .then()
               .statusCode(200)
               .body(is("{\"personId\":151,\"firstName\":null,\"lastName\":null,\"email\":null}"));
    }

    @Test
    public void test_get_by_id() {
        given().when()
               .get("/person/1")
               .then()
               .statusCode(200)
               .body(is("{\"personId\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"}"));
    }

//    @Test
//    public void test_delete() {
//        given().when()
//               .delete("/person/101")
//               .then()
//               .statusCode(200)
//               .body(is("true"));
//
//        given().when()
//               .get("/person/101")
//               .then()
//               .statusCode(200)
//               .body(is(""));
//    }

    @Test
    public  void test_get_most_relevant_actor() {
        given().when()
               .get("/person/mostRelevant/" + PersonType.actors)
               .then()
               .statusCode(200)
               .body(is("{\"personId\":101,\"firstName\":\"Alice\",\"lastName\":\"Johnson\",\"email\":\"alice.johnson@example.com\"}"));
    }
}
