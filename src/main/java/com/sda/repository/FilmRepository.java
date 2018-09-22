package com.sda.repository;

import com.sda.domain.Film;
import com.sda.domain.FilmCategory;

import java.util.ArrayList;
import java.util.List;

public class FilmRepository {

    public Film findById(Short filmId) {
        //TODO implement
        return null;
    }

    public List<Film> findFilmsByRating(String rating) {
        //TODO implement
        return new ArrayList<>();
    }

    public List<Film> findByActorNameAndSurname(String name, String surname) {
        //TODO implement
        return new ArrayList<>();
    }

    public List<FilmCategory> findFilmCategories(Short filmId) {
        //TODO implement
        return new ArrayList<>();
    }
}
