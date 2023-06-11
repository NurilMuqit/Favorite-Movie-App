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
import com.example.h071211034_finalmobile.model.TvResponse;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {
    private List<TvResponse> dataTv;
    public SeriesAdapter(List<TvResponse> dataTv){
        this.dataTv =dataTv;
    }
    @NonNull
    @Override
    public SeriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.movie_list,parent,false);

        SeriesAdapter.ViewHolder viewHolder = new SeriesAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesAdapter.ViewHolder holder, int position) {
        TvResponse tvResponse = dataTv.get(position);
        holder.movie_name.setText(tvResponse.getName());
        holder.movie_date.setText(tvResponse.getFirst_air_date().substring(0,4));
        Glide.with(holder.itemView.getContext()).load(IMG_BASE_URL + tvResponse.getPoster_path()).into(holder.movie_poster);
    }

    @Override
    public int getItemCount() {
        return dataTv.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView movie_poster;
        TextView movie_date, movie_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_poster = itemView.findViewById(R.id.movie_poster);
            movie_date = itemView.findViewById(R.id.movie_date);
            movie_name = itemView.findViewById(R.id.movie_name);
        }
    }
}
