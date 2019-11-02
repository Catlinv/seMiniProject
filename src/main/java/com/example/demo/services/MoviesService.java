package com.example.demo.services;

import com.example.demo.domain.Movie;
import org.springframework.stereotype.Service;

@Service
public interface MoviesService {

    Movie findMovieById(Long id);

    Iterable<Movie> listAllMovies();

    Movie saveMovie(Movie movie);


    void deleteMovie(Long id);
}
