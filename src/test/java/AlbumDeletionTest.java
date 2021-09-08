import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AlbumDeletionTest extends BaseApiTest {
    public AlbumDeletionTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        FileUtils.simpleAlbumCreate();
    }

    @Test
    void authedDeleteTest() {
        given()
                .spec(FileUtils.baseRequestSpecAuth)
                .when()
                .delete(Endpoints.ALBUM_AUTH_DELETE, FileUtils.albumHash)
                .then()
                .statusCode(200);
    }

    @Test
    void unAuthedDeleteTest() {
        given()
                .spec(FileUtils.baseRequestSpecUnAuth)
                .when()
                .delete(Endpoints.ALBUM_UNAUTH_DELETE, FileUtils.albumDeleteHash)
                .then()
                .statusCode(403);
        FileUtils.simpleAlbumDelete();
    }
}

