package io.redbee.academy.persistence.hibernate.repository;

import io.redbee.academy.persistence.hibernate.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class PostgresMovieRepository implements MovieRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostgresMovieRepository.class);

    private static final String GET_ALL_MOVIES_QUERY = "FROM Movie";
    private static final String GET_MOVIE_BY_TITLE_SEARCH_TERM_QUERY = "FROM Movie AS m WHERE m.title LIKE :searchTerm";

    private EntityManager entityManager;

    public PostgresMovieRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> getAll() {
        LOGGER.info("Get all movies from database");
        return this.entityManager.createQuery(GET_ALL_MOVIES_QUERY, Movie.class)
                .getResultList();
    }

    @Override
    public Optional<Movie> find(Integer id) {
        LOGGER.info("Get movie with id {}", id);
        try {
            return Optional.of(this.entityManager.find(Movie.class, id));
        } catch (Throwable e) {
            LOGGER.error("An error occurs getting movie by id {}: {}", id, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Movie> find(String title) {
        LOGGER.info("Find movies by title '{}'", title);
        return this.entityManager.createQuery(GET_MOVIE_BY_TITLE_SEARCH_TERM_QUERY, Movie.class)
                .setParameter("searchTerm", "%" + title + "%")
                .getResultList();
    }

}
