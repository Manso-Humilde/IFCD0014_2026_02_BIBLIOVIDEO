package com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.repository;

import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository <Movie, Integer> {

    List<Movie> findByGenres_Id(Integer genreId);

    List<Movie> findByTitleContainingIgnoreCase(String title);

    //List<Movie> findByTitleContainingAndGenreId(String title, int genreId);

}
