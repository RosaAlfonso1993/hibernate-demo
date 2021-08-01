package io.redbee.academy.persistence.hibernate.repository;

import io.redbee.academy.persistence.hibernate.model.Genre;

import java.util.Optional;

public class DatabaseGenreRepository implements GenreRepository {

    @Override
    public Optional<Genre> find(Integer id) {
        throw new IllegalStateException("Not implemented yet");
    }

    @Override
    public Genre create(String description) {
        throw new IllegalStateException("Not implemented yet");
    }

}
