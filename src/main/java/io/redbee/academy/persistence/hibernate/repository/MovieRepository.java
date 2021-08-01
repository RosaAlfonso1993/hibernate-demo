package io.redbee.academy.persistence.hibernate.repository;

import io.redbee.academy.persistence.hibernate.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<Movie> getAll();

    Optional<Movie> find(Integer id);

    List<Movie> find(String title);

}
