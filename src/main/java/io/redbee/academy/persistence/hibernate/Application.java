package io.redbee.academy.persistence.hibernate;

import io.redbee.academy.persistence.hibernate.model.Movie;
import io.redbee.academy.persistence.hibernate.repository.MovieRepository;
import io.redbee.academy.persistence.hibernate.repository.PostgresMovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("Application start");
        final EntityManager entityManager = createEntityManager();
        final MovieRepository movieRepository = new PostgresMovieRepository(entityManager);

        final List<Movie> allMovies = movieRepository.getAll();
        LOGGER.info("Total of movies from DB: {}", allMovies.size());

        final Integer movieId = 1;
        final Optional<Movie> movieById = movieRepository.find(movieId);
        movieById.ifPresentOrElse(
                movie -> LOGGER.info("Movie {}: {} with genres {}", movieId, movie, movie.getGenres()),
                () -> LOGGER.info("Movie not found for id {}", movieId)
        );

        final String searchTerm = "o";
        final List<Movie> moviesByTitle = movieRepository.findByTitle(searchTerm);
        LOGGER.info("Movies with '{}': {}", searchTerm, moviesByTitle.size());
        moviesByTitle.forEach(movie -> LOGGER.info(movie.toString()));

        final Movie newMovie = movieRepository.create("Se7en", 1995);
        LOGGER.info("Created movie: {}", newMovie);

        LOGGER.info("Application end");
    }

    private static EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory("movies")
                .createEntityManager();
    }

}
