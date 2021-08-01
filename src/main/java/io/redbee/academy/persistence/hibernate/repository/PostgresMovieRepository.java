package io.redbee.academy.persistence.hibernate.repository;

import io.redbee.academy.persistence.hibernate.model.Movie;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PostgresMovieRepository implements MovieRepository {

    @Override
    public List<Movie> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Movie> find(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Movie> find(String title) {
        return Collections.emptyList();
    }

}
