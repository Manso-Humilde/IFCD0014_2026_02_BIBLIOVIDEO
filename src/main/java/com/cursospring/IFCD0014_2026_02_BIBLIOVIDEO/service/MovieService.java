package com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.service;

import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model.Movie;
import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    IMovieRepository imr;

    private IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository){
        this.movieRepository = movieRepository;
        List<Movie> movies = this.movieRepository.findAll();
       // return movies;
    }

    public List<Movie> getAllMovies(){
        return imr.findAll();
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public Movie getMovieById(Integer id){
        return movieRepository.findById(id).orElse(null);
    }

    public List<Movie> getMoviesByGenre(Integer genreId){
        return movieRepository.findByGenres_Id(genreId);
    }

    public List<Movie> searchMovies(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

}
