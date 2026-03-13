package com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.controller;

import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model.Genre;
import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model.Movie;
import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.service.GenreService;
import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private GenreService gs;
    private MovieService ms;
    public MainController(GenreService gs, MovieService ms) {
        this.gs = gs;
        this.ms = ms;
    }
    //http://localhost:8080
    @GetMapping("/")
    public String getMainPage(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer genre,
            Model model){

        List<Genre> genresList = gs.getAllGenres();
        model.addAttribute("genres", genresList);

        List<Movie> movieList;

        if(title != null && !title.isEmpty()){
            movieList = ms.searchMovies(title);
        }
        else if(genre != null){
            movieList = ms.getMoviesByGenre(genre);
        }
        else{
            movieList = ms.getAllMovies();
        }

        model.addAttribute("movies", movieList);

        return "index";
    }

    @GetMapping("/createMovie")
    public String createMovie(Model model) {

        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", gs.getAllGenres());

        return "new-movie";
    }

    @PostMapping("/createMovie")
    public String createMovie(@ModelAttribute Movie movie, Model model){
        this.ms.saveMovie(movie);
        return "redirect:/";
    }
//
//    @GetMapping("/movie/{id}")
//    public String getMovieDetail(@PathVariable Integer id, Model model){
//
//        Movie movie = ms.getMovieById(id);
//
//        model.addAttribute("movie", movie);
//
//        return "movie-detail";
//    }

    @GetMapping("/movie/{id}")
    public String getMovieDetail(@PathVariable Integer id, Model model){

        Movie movie = ms.getMovieById(id);

        model.addAttribute("movie", movie);

        return "movie-detail";
    }

}

