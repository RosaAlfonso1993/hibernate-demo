package io.redbee.academy.persistence.hibernate;

import io.redbee.academy.persistence.hibernate.model.Movie;
import io.redbee.academy.persistence.hibernate.repository.MovieRepository;
import io.redbee.academy.persistence.hibernate.repository.PostgresMovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Application start");
        MovieRepository movieRepository = new PostgresMovieRepository();

        final List<Movie> allMovies = movieRepository.getAll();
        LOGGER.info("Total of movies from DB: {}", allMovies.size());

        final long movieId = 1L;
        final Optional<Movie> movieById = movieRepository.find(movieId);
        movieById.ifPresentOrElse(
                movie -> LOGGER.info("Movie {}: {}", movieId, movie),
                () -> LOGGER.info("Movie not found for id {}", movieId)
        );

        LOGGER.info("Application end");
    }

}
