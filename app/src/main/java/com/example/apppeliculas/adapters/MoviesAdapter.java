package com.example.apppeliculas.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.apppeliculas.R;
import com.example.apppeliculas.models.Movie;

import java.util.List;
import java.util.zip.Inflater;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private List<Movie> lstMovies;

    public MoviesAdapter(List<Movie> lstMovies) {
        this.lstMovies = lstMovies;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext())
                .inflate( R.layout.item_movie, parent, false );
        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {
        Movie movie = lstMovies.get(position);
        holder.txtTitle.setText( lstMovies.get(position).getTitle() );
        Glide.with( holder.itemView.getContext() )
                .load("https://image.tmdb.org/t/p/w500/" + movie.getPoster_path())
                //.override(800,600)
                .centerCrop()
                .into( holder.imgvPosterPath)
                ;
        //holder.imgvPosterPath.setImageURI(movie.getPoster_path());
    }

    @Override
    public int getItemCount() {
        return lstMovies.size();
    }
}

class MoviesViewHolder extends RecyclerView.ViewHolder {
    public TextView txtTitle;
    public ImageView imgvPosterPath;

    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle= itemView.findViewById(R.id.txtTitle);
        imgvPosterPath = itemView.findViewById(R.id.imgvPosterPath);
    }
}