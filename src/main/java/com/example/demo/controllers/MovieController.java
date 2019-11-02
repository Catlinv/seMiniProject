package com.example.demo.controllers;

import com.example.demo.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.MoviesService;

import java.util.List;


//@RequestMapping(MovieController.BASE_URL)
@Controller
public class MovieController {
    private MoviesService moviesService;
    //public static final String BASE_URL = "/api/movies";

    public MovieController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @Autowired
    public void setMovieService(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @RequestMapping(value = "movies", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("movies", moviesService.listAllMovies());
        return "movies";
    }

    @GetMapping("/movie/{id}")
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

    @DeleteMapping("/movie/{id}")
    void deleteMovie(@PathVariable Long id){
         moviesService.deleteMovie(id);
    }

}
