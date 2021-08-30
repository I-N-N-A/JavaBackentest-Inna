import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DeleteImage extends BaseApiTest {
    String imageDeleteHash;


    public DeleteImage() throws IOException {
    }

    @BeforeEach
    void setUp() {
        imageDeleteHash = given()
                .auth()
                .oauth2(getToken())
                .multiPart("image", new File( "./src/main/resources/3-1271.jpg"))
                .when()
                .post("3/upload")
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void deleteExistentImageTest() {
        given()
                .auth()
                .oauth2(getToken())
                .when()
                .delete("3/image/{imageHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}
