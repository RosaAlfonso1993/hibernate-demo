package io.redbee.academy.persistence.hibernate.repository;

import io.redbee.academy.persistence.hibernate.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class DatabaseMovieRepository implements MovieRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseMovieRepository.class);

    private static final String GET_ALL_MOVIES_QUERY = "FROM Movie";
    private static final String SEARCH_TERM_KEY = "searchTerm";
    private static final String GET_MOVIE_BY_TITLE_SEARCH_TERM_QUERY = "FROM Movie AS m WHERE m.title LIKE :" + SEARCH_TERM_KEY;

    private EntityManager entityManager;

    public DatabaseMovieRepository(EntityManager entityManager) {
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
    public List<Movie> findByTitle(String term) {
        LOGGER.info("Find movies by title '{}'", term);
        return this.entityManager.createQuery(GET_MOVIE_BY_TITLE_SEARCH_TERM_QUERY, Movie.class)
                .setParameter(SEARCH_TERM_KEY, "%" + term + "%")
                .getResultList();
    }

    @Override
    public Movie create(String title, Integer year) {
        LOGGER.info("Create new movie with title = '{}' and year = {}", title, year);
        final Movie movie = new Movie();
        movie.setTitle(title);
        movie.setYear(year);
        movie.setCreationUser("hibernate-demo-app");
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(movie);
        this.entityManager.getTransaction().commit();
        return movie;
    }

}
