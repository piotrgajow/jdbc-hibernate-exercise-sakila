package com.sda.repository;

import com.sda.domain.FilmCategory;
import com.sda.domain.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FilmRepositorySpec {

    private FilmRepository filmRepository;

    @BeforeEach
    void setUp() {
        filmRepository = new FilmRepository();
    }

    @ParameterizedTest
    @MethodSource("filmParameters")
    void testFindingFilmsById(Short filmId, String title, BigDecimal rentalRate, Short length) {
        Film foundFilm = filmRepository.findById(filmId);

        assertThat(foundFilm, hasProperty("title", equalTo(title)));
        assertThat(foundFilm, hasProperty("rentalRate", equalTo(rentalRate)));
        assertThat(foundFilm, hasProperty("length", equalTo(length)));
    }

    private static Stream<Arguments> filmParameters() {
        return Stream.of(
                Arguments.of((short)36, "ARGONAUTS TOWN", BigDecimal.valueOf(0.99), (short)127),
                Arguments.of((short)565, "MATRIX SNOWMAN", BigDecimal.valueOf(4.99), (short)56),
                Arguments.of((short)615, "NASH CHOCOLAT", BigDecimal.valueOf(2.99), (short)180)
        );
    }

    @ParameterizedTest
    @MethodSource("filmCategoriesParameters")
    void testFindingFilmAndGettingCategories(Short filmId, String category) {
        List<FilmCategory> categories = filmRepository.findFilmCategories(filmId);

        assertThat(categories, hasItem(hasProperty("name", equalTo(category))));
    }

    private static Stream<Arguments> filmCategoriesParameters() {
        return Stream.of(
                Arguments.of((short)65, "Horror"),
                Arguments.of((short)300, "Animation"),
                Arguments.of((short)792, "Foreign")
        );
    }

    @ParameterizedTest
    @MethodSource("filmRatingParameters")
    void testFindingFilmsByRating(String rating, Integer expectedNumberOfFilms) {
        List<Film> foundFilms = filmRepository.findFilmsByRating(rating);

        assertThat(foundFilms.size(), is(equalTo(expectedNumberOfFilms)));
    }

    private static Stream<Arguments> filmRatingParameters() {
        return Stream.of(
                Arguments.of("R", 195),
                Arguments.of("G", 178),
                Arguments.of("PG-13", 223)
        );
    }

    @ParameterizedTest
    @MethodSource("filmActorParameters")
    void testFindingFilmsByActor(String name, String surname, Integer expectedNumberOfFilms) {
        List<Film> foundFilms = filmRepository.findByActorNameAndSurname(name, surname);

        assertThat(foundFilms.size(), is(equalTo(expectedNumberOfFilms)));
    }

    private static Stream<Arguments> filmActorParameters() {
        return Stream.of(
                Arguments.of("KIRSTEN", "PALTROW",  27),
                Arguments.of("JULIA", "ZELLWEGER", 16)
        );
    }

}