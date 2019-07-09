package com.example.a65gbtesttask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String BASE_URL = "https://gitlab.65apps.com";

    private static NetworkService mInstance;
    private static Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public TestApi getApi() {
        return mRetrofit.create(TestApi.class);
    }
}
