package com.cursospring.IFCD0014_2026_02_BIBLIOVIDEO.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String urlThumbnail;
    private String urlVideo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, String urlThumbnail, String urlVideo, List<Genre> genres) {
        this.title = title;
        this.urlThumbnail = urlThumbnail;
        this.urlVideo = urlVideo;
        this.genres = genres;
    }

    public Movie(int id, String title, String urlThumbnail, String urlVideo, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.urlThumbnail = urlThumbnail;
        this.urlVideo = urlVideo;
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    public void setUrlThumbnail(String urlThumbnail) {
        this.urlThumbnail = urlThumbnail;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urlThumbnail='" + urlThumbnail + '\'' +
                ", urlVideo='" + urlVideo + '\'' +
                ", genres=" + genres +
                '}';
    }
}
