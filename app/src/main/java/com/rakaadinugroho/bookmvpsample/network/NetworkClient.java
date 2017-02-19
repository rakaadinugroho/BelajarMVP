package com.rakaadinugroho.bookmvpsample.network;

import com.rakaadinugroho.bookmvpsample.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raka Adi Nugroho on 2/17/17.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class NetworkClient {
    private static Retrofit retrofit;
    private static final String BASE_URL    = "https://www.googleapis.com/books/v1/";
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
