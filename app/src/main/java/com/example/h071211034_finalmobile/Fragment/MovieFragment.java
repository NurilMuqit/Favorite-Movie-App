package com.example.h071211034_finalmobile.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.h071211034_finalmobile.Adapter.MovieAdapter;
import com.example.h071211034_finalmobile.Api.ApiConfig;
import com.example.h071211034_finalmobile.R;
import com.example.h071211034_finalmobile.model.Movie;
import com.example.h071211034_finalmobile.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {
    private MovieAdapter adapter;
    private List<MovieResponse> dataMovie = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.mov_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        setDataMovie();
    }

    private void setDataMovie(){
        Call<Movie> movieCall = ApiConfig.getApiService().getMovie();
        movieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

                    dataMovie = response.body().getData();
                    adapter = new MovieAdapter(dataMovie);
                    recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                System.out.println("Hello world");
            }
        });
    }

}