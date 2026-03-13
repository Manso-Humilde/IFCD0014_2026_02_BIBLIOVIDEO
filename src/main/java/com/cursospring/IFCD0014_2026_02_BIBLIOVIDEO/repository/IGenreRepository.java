package com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.repository;

import com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository <Genre, Integer> {

}
