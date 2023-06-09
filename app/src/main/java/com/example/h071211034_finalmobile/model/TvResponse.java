package com.example.h071211034_finalmobile.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class TvResponse implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("first_air_date")
    private String first_air_date;
    @SerializedName("name")
    private String name;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("vote_average")
    private float vote_average;

    public int getId() {
        return id;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public float getVote_average() {
        return vote_average;
    }

    protected TvResponse(Parcel in) {
        id = in.readInt();
        backdrop_path = in.readString();
        first_air_date = in.readString();
        name = in.readString();
        overview = in.readString();
        poster_path = in.readString();
        vote_average = in.readFloat();
    }

    public static final Creator<TvResponse> CREATOR = new Creator<TvResponse>() {
        @Override
        public TvResponse createFromParcel(Parcel in) {
            return new TvResponse(in);
        }

        @Override
        public TvResponse[] newArray(int size) {
            return new TvResponse[size];
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
        dest.writeString(first_air_date);
        dest.writeString(name);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeFloat(vote_average);
    }
}
