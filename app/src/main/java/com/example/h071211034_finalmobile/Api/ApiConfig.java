package com.example.h071211034_finalmobile.Api;

import static com.example.h071211034_finalmobile.Server.ServerConfig.URL_BASE;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
        public static ApiService getApiService(){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL_BASE)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                return retrofit.create(ApiService.class);
        };

}
