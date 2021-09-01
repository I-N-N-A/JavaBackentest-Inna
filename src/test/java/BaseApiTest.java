import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.util.Properties;

abstract class BaseApiTest {

    private final String token;
    private final String baseUri;
    private final String userName;
    private final PropertyScanner scanner;
    protected ResponseSpecification responseSpecification = null;
    protected MultiPartSpecification multiPartSpecification= null;
    protected RequestSpecification requestSpecification= null;
    protected static Properties testProps = new Properties();
    private static final String testPropertiesPath = "src/test/resources/application.properties";

    public BaseApiTest() throws IOException {
        scanner = new PropertyScanner();
        token = scanner.getProperty("imgur.auth.token");
        baseUri = scanner.getProperty("imgur.api.url");
        userName = scanner.getProperty("imgur.username");
    }

    public String getToken() {
        return token;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public String getUserName() {
        return userName;
    }

    public PropertyScanner getScanner() {
        return scanner;
    }

}
