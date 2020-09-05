package com.example.apppeliculas.networking;

import com.example.apppeliculas.models.MovieResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ClientApi {

    //popular?api_key=d7b7536b60bd1ae147b5aed762f886ee&language=es-ES&page=1
    @GET("popular")
    Call<MovieResponse> getMoviesResponsePop(
            @QueryMap Map<String,String> map
    );

    @GET("popular")
    Call<MovieResponse> getMoviesResponsePop2(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );

    @GET("popular?api_key=d7b7536b60bd1ae147b5aed762f886ee&language=es-ES&page=1")
    Call<MovieResponse> getMoviesResponsePop3();
}
