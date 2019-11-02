package com.example.demo.services;

import com.example.demo.domain.Movie;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.MovieRepository;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MovieRepository movieRepository;

    public MoviesServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findMovieById(Long id) {

        return movieRepository.findById(id).get();
    }


    @Override
    public Iterable<Movie> listAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    @Override
    public void deleteMovie(Long id) {
         movieRepository.delete(movieRepository.findById(id).get());
    }
}
