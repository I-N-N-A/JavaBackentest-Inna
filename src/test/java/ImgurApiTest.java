import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.Argument;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

class ImgurApiTest extends BaseApiTest {
    private String currentDeleteHash;

    public ImgurApiTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = getBaseUri();
    }


    @AfterEach
    void tearDown() {

    }

    @Test
    @DisplayName("Получение информации об аккаунте")
    void testGetAccountBase() {

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .auth()
                .oauth2(getToken())
                .expect()
                .body("data.url", is("gyzhova"))
                .log()
                .all()
                .statusCode(200)
                .when()
                .get("3/account/{username}", getUserName());
    }

    @Test
    @DisplayName("Тест загрузки картинки")
    void testImageUpload() throws Exception {

        currentDeleteHash = given()
                .auth()
                .oauth2(getToken())
                .when()
                .header(new Header("content-type", "multipart/form-data"))
                .multiPart("image", new File( "./src/main/resources/3-1271.jpg"))
                .expect()
                .statusCode(200)
                .body("data.id", is(notNullValue()))
                .body("data.deletehash", is(notNullValue()))
                .log()
                .all()
                .when()
                .post("3/upload")
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    @DisplayName("Удаление авторизованным пользователем")
    void deleteImageAuthedTest() {
        given()

                .auth()
                .oauth2(getToken())
                .expect()
                .body("data", is(true))
                .body("success", is(true))
                .when()
                .delete("3/image/{imageHash}")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

}
