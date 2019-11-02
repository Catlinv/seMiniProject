package com.example.demo.services;

import com.example.demo.domain.Movie;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.MovieRepository;

import java.util.List;

@Service
public class MoviesServiceImpl implements MoviesService {

    private final MovieRepository movieRepository;

    public MoviesServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.getOne(id);
    }

    @Override
    public List<Movie> findAllMovies() {

        return movieRepository.findAll();
    }
}
