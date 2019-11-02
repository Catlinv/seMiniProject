package com.example.demo.controllers;

import com.example.demo.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.MoviesService;

import java.util.List;

@RestController
@RequestMapping(MovieController.BASE_URL)
public class MovieController {
    private final MoviesService moviesService;
    public static final String BASE_URL = "/api/movies";

    public MovieController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping
    List<Movie> getAllMovies() {
        return moviesService.findAllMovies();
    }

    @GetMapping("/{id}")
    Movie getMovieById(@PathVariable Long id){
        return moviesService.findMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Movie addMovie(@RequestBody Movie movie){
        return  moviesService.saveMovie(movie);
    }

    @PutMapping
    Movie editMovie(@RequestBody Movie movie){
        return moviesService.editMovie(movie);
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable Long id){
         moviesService.deleteMovie(id);
    }

}
