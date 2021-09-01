import io.restassured.builder.MultiPartSpecBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class AlbumUpdateTest extends BaseApiTest{
    String updateName;
    String updatedDesc;

    public AlbumUpdateTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        FileUtils.simpleAlbumCreate();
        updateName = testProps.getProperty("updateted.album.name");
        updatedDesc = testProps.getProperty("updated.album.description");
        multiPartSpecification = new MultiPartSpecBuilder(updateName).controlName("title").build();
        requestSpecification = FileUtils.baseRequestSpecAuth.multiPart(multiPartSpecification).multiPart("description", updatedDesc);
    }

    @Test
    void updateAlbumTest() {
        given()
                .spec(requestSpecification)
                .expect()
                .body("data", is(true))
                .body("success", is(true))
                .when()
                .put(Endpoints.ALBUM_UPDATE, FileUtils.albumHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @AfterEach
    void tearDown() {
        FileUtils.simpleAlbumDelete();
    }
}
