package com.example.h071211034_finalmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse implements Parcelable {
    public MovieResponse(int id, String backdrop_path, String title, String overview, String poster_path, String release_date, float vote_average) {
        this.id = id;
        this.backdrop_path = backdrop_path;
        this.title = title;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    @SerializedName("id")
    private int id;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("vote_average")
    private float vote_average;

    protected MovieResponse(Parcel in) {
        id = in.readInt();
        backdrop_path = in.readString();
        title = in.readString();
        overview = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        vote_average = in.readFloat();
    }

    public static final Creator<MovieResponse> CREATOR = new Creator<MovieResponse>() {
        @Override
        public MovieResponse createFromParcel(Parcel in) {
            return new MovieResponse(in);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(backdrop_path);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeFloat(vote_average);
    }
}
