package com.example.h071211034_finalmobile.Adapter;

import static com.example.h071211034_finalmobile.Server.ServerConfig.IMG_BASE_URL;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.h071211034_finalmobile.R;
import com.example.h071211034_finalmobile.model.MovieResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<MovieResponse> dataMovie;

    public MovieAdapter(List<MovieResponse> dataMovie) {
        this.dataMovie =dataMovie;
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
        MovieResponse movieResponse = dataMovie.get(position);
        holder.movie_name.setText(movieResponse.getTitle());
        holder.movie_date.setText(movieResponse.getRelease_date().substring(0,4));
        Glide.with(holder.itemView.getContext()).load(IMG_BASE_URL +movieResponse.getPoster_path()).into(holder.movie_poster);
    }

    @Override
    public int getItemCount(){
        return dataMovie.size();
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
