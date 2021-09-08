import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit.api.MiniMarketApi;
import retrofit.dto.Category;
import retrofit.dto.ProductDto;
import retrofit.utils.RetrofitGetter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {
    private final MiniMarketApi api;

    public ApiTest() throws IOException {
        Retrofit retrofit = new RetrofitGetter().getInstance();
        api = retrofit.create(MiniMarketApi.class);
    }

    @Test
    @DisplayName("Create product")
    void testCreateProduct() throws IOException {

        ProductDto.ProductDtoBuilder builder = ProductDto.builder();
        builder.title("Water");
        builder.categoryTitle(Category.FOOD.getTitle());
        builder.price(15L);
        ProductDto dto = builder
                .build();

        Response<ProductDto> response = api.createProduct(dto).execute();
        assert response.body() != null;
        Long id = response.body().getId();

        ProductDto actually = api.getProduct(id).execute().body();

        assert actually != null;
        assertEquals(dto.getTitle(), actually.getTitle());
        assertEquals(dto.getPrice(), actually.getPrice());
        assertEquals(dto.getCategoryTitle(), actually.getCategoryTitle());

        api.deleteProduct(id).execute();
    }




    @Test
    @DisplayName("Getting product info")
    void testGetProduct() throws IOException {

        ProductDto dto = ProductDto.builder()
                .id(10L)
                .title("Bread")
                .categoryTitle(Category.FOOD.getTitle())
                .price(20L)
                .build();

        Response<ProductDto> response = api.getProduct(dto.getId()).execute();
        assert response.body() != null;
        Long id = response.body().getId();

        ProductDto actually = api.getProduct(id).execute().body();

        assert actually != null;
        assertEquals(dto.getTitle(), actually.getTitle());
        assertEquals(dto.getPrice(), actually.getPrice());
        assertEquals(dto.getCategoryTitle(), actually.getCategoryTitle());

    }

    @Test
    @DisplayName("Updating product info")
    void testUpdateProduct() throws IOException {

        ProductDto dto = ProductDto.builder()
                .id(5L)
                .title("Sugar")
                .categoryTitle(Category.FOOD.getTitle())
                .price(3L)
                .build();

        Response<ProductDto> response = api.updateProduct(dto).execute();
        assert response.body() != null;
        Long id = response.body().getId();

        ProductDto actually = api.getProduct(id).execute().body();

        assert actually != null;
        assertEquals(dto.getPrice(), actually.getPrice());
    }

    @Test
    @DisplayName("Delete product")
    void testDeleteProduct() throws IOException {

        ProductDto dto = ProductDto.builder()
                .title("Bread")
                .categoryTitle(Category.FOOD.getTitle())
                .price(20L)
                .build();

        Response<ProductDto> response = api.createProduct(dto).execute();

        assert response.body() != null;
        Long id = response.body().getId();

        api.deleteProduct(id).execute();

        api.getProduct(id).execute();

        new AssertionError("There is no product with id: " + dto.getId());
    }
}
