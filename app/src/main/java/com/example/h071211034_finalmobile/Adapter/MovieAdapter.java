package com.example.h071211034_finalmobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211034_finalmobile.R;
import com.example.h071211034_finalmobile.model.Movie;
import com.example.h071211034_finalmobile.model.MovieResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> resultList;

    public MovieAdapter(Context context, List<Movie> resultList) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.movie_list,parent,false);

        MovieAdapter.MyViewHolder viewHolder = new MovieAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movieResponse = resultList.get(position);
    }

    @Override
    public int getItemCount(){
        return 0;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ShapeableImageView movie_poster;
        TextView movie_date, movie_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            movie_poster = itemView.findViewById(R.id.movie_poster);
            movie_date = itemView.findViewById(R.id.movie_date);
            movie_name = itemView.findViewById(R.id.movie_name);
        }
    }
}
