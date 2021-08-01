package io.redbee.academy.persistence.hibernate.repository;

import io.redbee.academy.persistence.hibernate.model.Genre;

import java.util.Optional;

public interface GenreRepository {

    Optional<Genre> find(Integer id);

    Genre create(String description);

}
