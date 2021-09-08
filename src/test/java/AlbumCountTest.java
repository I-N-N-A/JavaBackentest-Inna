import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlbumCountTest extends BaseApiTest {
    int initialCount, updatedCount;

    public AlbumCountTest() throws IOException {
    }

    @BeforeEach
    void setUp() {
        initialCount = FileUtils.getAlbumCount();
        FileUtils.simpleAlbumCreate();
        updatedCount = FileUtils.getAlbumCount();
    }

    @Test
    @RepeatedTest(10)
    void getAlbumCountTest(){
        assertThat(updatedCount-initialCount, equalTo(1));
    }

    @AfterEach
    void tearDown() {
        FileUtils.simpleAlbumDelete();
    }

}
