package com.example.h071211034_finalmobile.Api;

import static com.example.h071211034_finalmobile.Server.ServerConfig.API_KEY;

import com.example.h071211034_finalmobile.model.MovieResponse;
import com.example.h071211034_finalmobile.model.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movie/popular?api_key=" + API_KEY)
    Call<MovieResponse> getMovie();

    @GET("tv/popular?api_key=" + API_KEY)
    Call<TvResponse> getTv();
}
