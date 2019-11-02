package com.example.demo.controllers;

import com.example.demo.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.MoviesService;

@Controller
public class MovieController {
    private MoviesService moviesService;

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

    @RequestMapping(value = "movie", method = RequestMethod.POST)
    public String saveProduct(Movie movie) {
        moviesService.saveMovie(movie);
        return "redirect:/movies";
    }

    @RequestMapping("movie/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("movie", moviesService.findMovieById(id));
        return "movieform";
    }

    @RequestMapping("movie/new")
    public String newProduct(Model model) {
        model.addAttribute("movie", new Movie());
        return "movieform";
    }

    @RequestMapping("/movie/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        moviesService.deleteMovie(id);
        return "redirect:/movies";
    }

}
