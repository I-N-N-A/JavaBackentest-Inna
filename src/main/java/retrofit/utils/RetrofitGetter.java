package retrofit.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class RetrofitGetter {

    private final PropertyScanner ps;
    private final OkHttpClient client;
    private final String baseUrl;

    public RetrofitGetter() throws IOException {
        ps = new PropertyScanner();
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        baseUrl = ps.getProperty("mini.market.url");
        client = new OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();
    }

    public Retrofit getInstance() {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

}
