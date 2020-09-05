package com.example.apppeliculas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.apppeliculas.adapters.MoviesAdapter;
import com.example.apppeliculas.models.Movie;
import com.example.apppeliculas.models.MovieResponse;
import com.example.apppeliculas.networking.ClientApi;
import com.example.apppeliculas.networking.RetrofitUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private RecyclerView recyMovies;
    private MoviesAdapter moviesAdapter;
    private List<Movie> lstMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult= findViewById(R.id.txtResult);
        recyMovies = findViewById(R.id.recyMovies);

        setRecyMovies();
    }

    private void setRecyMovies(){
        recyMovies.setLayoutManager( new LinearLayoutManager(this));
        lstMovies = new ArrayList<>();
        //lstMovies = callServiceMovies();
        moviesAdapter =  new MoviesAdapter(lstMovies);
        recyMovies.setAdapter(moviesAdapter);
        callServiceMovies();
        //moviesAdapter.notifyDataSetChanged();

    }

    private void callServiceMovies(){
        String api_key, language;
        int page;
        api_key ="d7b7536b60bd1ae147b5aed762f886ee";
        language="es-ES";
        page = 1;
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("api_key",api_key);
        requestMap.put("language",language);
        requestMap.put("page", Integer.valueOf( page ).toString() );

        Call<MovieResponse> callMovies =  RetrofitUtil.getClientMovie().getMoviesResponsePop( requestMap );

        callMovies.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if(response.isSuccessful()){
                    //txtResult.setText("Done:" + response.body().toString());
                    List<Movie> movs = response.body().getResults();
                    /*String cadTitle = "";
                    for(Movie mov : movs){
                        cadTitle = cadTitle + " - " + mov.getTitle();
                    }
                    txtResult.setText("Done:" + cadTitle);*/
                    lstMovies.addAll(movs);
                    moviesAdapter.notifyDataSetChanged();
                    Log.i("done:" , "se llamó al servicio" );
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                txtResult.setText("Error!!!");
                Log.e("error:" , "no se llamó al servicio" );
            }
        });
    }


}
