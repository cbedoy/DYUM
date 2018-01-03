package cbedoy.com.doyouunderstandme;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Doyouunderstandme
 * <p>
 * Created by bedoy on 1/2/18.
 */

public class ServiceGenerator
{
    private static Retrofit retrofitInstance(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("X-AYLIEN-TextAPI-Application-Key", BuildConfig.APP_KEY)
                        .header("X-AYLIEN-TextAPI-Application-ID", BuildConfig.APP_ID)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

    public static <S> S createService(Class<S> serviceClass){
        return retrofitInstance().create(serviceClass);
    }
}
