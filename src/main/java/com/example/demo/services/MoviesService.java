package com.example.demo.services;

import com.example.demo.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MoviesService {

    Movie findMovieById(Long id);

    List<Movie> findAllMovies();
}
