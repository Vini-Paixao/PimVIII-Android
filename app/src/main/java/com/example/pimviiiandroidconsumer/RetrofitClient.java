package com.example.pimviiiandroidconsumer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://pimviii.marcuspaixao.com.br/";

    private static Retrofit retrofit = null;

    public static ApiService getApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // Usa Gson
                    .build();
        }
        // Cria a implementação da interface ApiService
        return retrofit.create(ApiService.class);
    }
}
