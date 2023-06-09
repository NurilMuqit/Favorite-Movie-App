package com.example.h071211034_finalmobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("results")
    private List<MovieResponse> results;

    public List<MovieResponse> getData(){
        return results;
    }
}
