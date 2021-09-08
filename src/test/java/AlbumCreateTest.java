import io.restassured.builder.MultiPartSpecBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class AlbumCreateTest extends BaseApiTest{


    public AlbumCreateTest() throws IOException {
    }

    @BeforeEach
        void setUp() {
            multiPartSpecification = new MultiPartSpecBuilder(testProps.getProperty("album.simple.description")).controlName("description").build();
            requestSpecification = FileUtils.baseRequestSpecAuth.multiPart(multiPartSpecification);
        }

        @ParameterizedTest
        @MethodSource("albumNames")
        void albumEnNameTest(String albumName) {
            FileUtils.albumHash = given()
                    .spec(requestSpecification).multiPart("title", albumName)
                    .when()
                    .post(Endpoints.ALBUM_CREATE)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response()
                    .jsonPath()
                    .getString("data.id");
        }


        @AfterEach
        void tearDown() {
            given()
                    .spec(FileUtils.baseRequestSpecAuth)
                    .when()
                    .delete(Endpoints.ALBUM_AUTH_DELETE, FileUtils.albumHash )
                    .then()
                    .statusCode(200);
        }

        private static Stream<String> albumNames(){
            return Stream.of(
                    testProps.getProperty("album.en.name"),
                    testProps.getProperty("album.ru.name"),
                    testProps.getProperty("album.chinese.name"),
                    testProps.getProperty("album.spec.symbol.name"),
                    testProps.getProperty("album.empty.name"));
        }
}
