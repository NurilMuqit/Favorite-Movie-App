package com.example.h071211034_finalmobile.Api;

import com.example.h071211034_finalmobile.Server.ServerConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
        private static Retrofit retrofit;

        public static Retrofit getRetrofit(){
                if(retrofit==null){
                        retrofit = new Retrofit.Builder().baseUrl(ServerConfig.URL_BASE)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                }
                return retrofit;
        }
}
