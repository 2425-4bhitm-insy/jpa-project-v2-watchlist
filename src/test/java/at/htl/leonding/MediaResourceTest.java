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
               .body(is("[{\"duration\":120,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Movie 1\",\"description\":\"Description for Movie 1\",\"mediaType\":\"MOVIE\",\"tags\":[{\"tagId\":1,\"name\":\"Action\"}]},{\"duration\":45,\"releaseDate\":\"2023-02-01\",\"rating\":4,\"edition\":1,\"name\":\"Series 1\",\"description\":\"Description for Series 1\",\"mediaType\":\"SERIES\",\"tags\":[{\"tagId\":51,\"name\":\"Drama\"}]},{\"duration\":60,\"releaseDate\":\"2023-03-01\",\"rating\":3,\"edition\":1,\"name\":\"Episode 1\",\"description\":\"Description for Episode 1\",\"mediaType\":\"EPISODE\",\"tags\":[{\"tagId\":101,\"name\":\"Comedy\"}]},{\"duration\":90,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Series\",\"description\":\"Series all episodes\",\"mediaType\":\"SERIES\",\"tags\":[]},{\"duration\":90,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Episode ONE\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\",\"tags\":[]},{\"duration\":90,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Episode TWO\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\",\"tags\":[]},{\"duration\":90,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Episode THREE\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\",\"tags\":[]},{\"duration\":90,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Episode FOUR\",\"description\":\"Series episode 1\",\"mediaType\":\"EPISODE\",\"tags\":[]}]"));
    }

    @Test
    public void test_get_by_id() {
        given().when()
               .get("/media/1")
               .then()
               .statusCode(200)
               .body(is("{\"duration\":120,\"releaseDate\":\"2023-01-01\",\"rating\":5,\"edition\":1,\"name\":\"Movie 1\",\"description\":\"Description for Movie 1\",\"mediaType\":\"MOVIE\",\"tags\":[{\"tagId\":1,\"name\":\"Action\"}]}"));
    }

    @Test
    public void test_get_average_rating_by_person() {
        given().when()
               .get("/media/averageRating/1")
               .then()
               .statusCode(200)
               .body(is("4.5"));
    }

    @Test
    public void test_create() {
        given().when()
               .contentType("application/json")
               .body("{\"duration\":0,\"releaseDate\":null,\"rating\":0,\"edition\":0,\"name\":\"Action\",\"description\":null,\"mediaType\":null,\"tags\":[]}")
               .post("/media")
               .then()
               .statusCode(200)
               .body(is("{\"duration\":0,\"releaseDate\":null,\"rating\":0,\"edition\":0,\"name\":\"Action\",\"description\":null,\"mediaType\":null,\"tags\":[]}"));
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

    @Test
    public void test_get_all_by_media_type() {
        given().when()
               .get("/media/type/MOVIE")
               .then()
               .statusCode(200)
               .body(is("[{\"personId\":1,\"firstName\":\"John\",\"lastName\":\"Doe\",\"email\":\"john.doe@example.com\"},{\"personId\":51,\"firstName\":\"Jane\",\"lastName\":\"Smith\",\"email\":\"jane.smith@example.com\"},{\"personId\":101,\"firstName\":\"Alice\",\"lastName\":\"Johnson\",\"email\":\"alice.johnson@example.com\"}]"));
    }

}

