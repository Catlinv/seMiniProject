package com.example.demo.bootstrap;

import com.example.demo.domain.Movie;
import org.springframework.boot.CommandLineRunner;
import com.example.demo.repositories.MovieRepository;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final MovieRepository movieRepository;

    public BootStrapData(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading Movie Data");

        Movie c1 = new Movie();
        c1.setTitle("Star Wars");
        c1.setYear(1984);
        movieRepository.save(c1);

        Movie c2 = new Movie();
        c2.setTitle("Real Steel");
        c2.setYear(2013);
        movieRepository.save(c2);

        Movie c3 = new Movie();
        c3.setTitle("Enders Game");
        c3.setYear(2017);
        movieRepository.save(c3);

        System.out.println("Movies Added: " + movieRepository.count());

    }


}
