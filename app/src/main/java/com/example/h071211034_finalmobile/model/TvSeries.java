package com.example.h071211034_finalmobile.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvSeries {
    @SerializedName("results")
    private List<TvResponse> results;

    public List<TvResponse> getData(){
        return results;
    }
}
