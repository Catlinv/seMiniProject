package com.example.demo.controllers;

import com.example.demo.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.MoviesService;

import java.util.List;

@RestController
@RequestMapping(MovieController.BASE_URL)
public class MovieController {
    private final MoviesService moviesService;
    public static final String BASE_URL = "/api/v1/movies";

    public MovieController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    List<Movie> getAllMovies(){
        return moviesService.findAllMovies();
    }

}
