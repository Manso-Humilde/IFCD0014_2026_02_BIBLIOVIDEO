package com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.service;

import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model.Genre;
import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.repository.IGenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private IGenreRepository genreRepository;

    public GenreService(IGenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres(){
        List<Genre> generos = this.genreRepository.findAll();
        return generos;
    }

    public Genre getGenreById(Integer id){
        return genreRepository.findById(id).orElse(null);
    }

    public void GenService (Genre genre){}

}
