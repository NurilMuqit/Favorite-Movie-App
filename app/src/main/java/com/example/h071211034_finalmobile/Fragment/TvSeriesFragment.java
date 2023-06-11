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

import com.example.h071211034_finalmobile.Adapter.SeriesAdapter;
import com.example.h071211034_finalmobile.Api.ApiConfig;
import com.example.h071211034_finalmobile.R;
import com.example.h071211034_finalmobile.model.TvResponse;
import com.example.h071211034_finalmobile.model.TvSeries;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvSeriesFragment extends Fragment {
    private SeriesAdapter adapter;
    private List<TvResponse> dataTv = new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv_series, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.tv_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        setDataTv();
    }
    public void setDataTv(){
        Call<TvSeries> tvSeriesCall = ApiConfig.getApiService().getTv();
        tvSeriesCall.enqueue(new Callback<TvSeries>() {
            @Override
            public void onResponse(Call<TvSeries> call, Response<TvSeries> response) {
                dataTv = response.body().getData();
                adapter = new SeriesAdapter(dataTv);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TvSeries> call, Throwable t) {
                System.out.println("Hello World");
            }
        });
    }
}