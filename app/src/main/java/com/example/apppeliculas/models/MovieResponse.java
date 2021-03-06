package com.example.apppeliculas.models;

import androidx.annotation.NonNull;

import java.util.List;

public class MovieResponse {

    int page;
    int total_results;
    int total_pages;
    List<Movie> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public String toString() {
        String resp = " total_results :" + Integer.valueOf(total_results).toString();
        return resp ;
    }
}
