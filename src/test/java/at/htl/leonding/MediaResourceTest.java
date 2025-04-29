package at.htl.leonding;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class MediaResourceTest {

    @Test
    public void test_get_all() {
        given().when()
               .get("/media/0")
               .then()
               .statusCode(200)
               .body(is("[{\"duration\":120,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Movie 1\",\"description\":\"Description for Movie 1\",\"mediaType\":\"MOVIE\"},{\"duration\":45,\"releaseDate\":[2023,2,1],\"rating\":4,\"edition\":1,\"name\":\"Series 1\",\"description\":\"Description for Series 1\",\"mediaType\":\"SERIES\"},{\"duration\":60,\"releaseDate\":[2023,3,1],\"rating\":3,\"edition\":1,\"name\":\"Episode 1\",\"description\":\"Description for Episode 1\",\"mediaType\":\"EPISODE\"},{\"duration\":90,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Series\",\"description\":\"Series all episodes\",\"mediaType\":\"SERIES\"},{\"duration\":90,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Episode ONE\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\"},{\"duration\":90,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Episode TWO\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\"},{\"duration\":90,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Episode THREE\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\"},{\"duration\":90,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Episode FOUR\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\"}]"));
    }

    @Test
    public void test_get_by_id() {
        given().when()
               .get("/media/1")
               .then()
               .statusCode(200)
               .body(is("{\"duration\":120,\"releaseDate\":[2023,1,1],\"rating\":5,\"edition\":1,\"name\":\"Movie 1\",\"description\":\"Description for Movie 1\",\"mediaType\":\"MOVIE\"}"));
    }

    @Test
    public void test_create() {
        given().when()
               .contentType("application/json")
               .body("{\"name\":\"Action\"}")
               .post("/media")
               .then()
               .statusCode(200)
               .body(is("{\"duration\":0,\"releaseDate\":null,\"rating\":0,\"edition\":0,\"name\":\"Action\",\"description\":null,\"mediaType\":null}"));
    }

    @Test
    public void test_delete() {
        given().when()
               .delete("/media/101")
               .then()
               .statusCode(200)
               .body(is("true"));

        given().when()
                .get("/media/101")
                .then()
                .statusCode(200)
                .body(is(""));
    }

}

