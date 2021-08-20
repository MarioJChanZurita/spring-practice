package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping("/addMovie")
    public void addMovie(@RequestBody Movie Movie){
        this.movieService.saveMovie(Movie);
    }

    @GetMapping("/findAllMovies")
    public List<Movie> getMovies(){
        return this.movieService.getMovies();
    }

    @GetMapping("/findMovie/{id}")
    public Optional<Movie> getMovie(@PathVariable String id){
        return this.movieService.getMovie(id);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable String id){
        this.movieService.deleteMovie(id);
    }

    @PutMapping("/updateMovie/{id}")    
    public void updateMovie(
        @PathVariable(value="id") String movieId, 
        @RequestBody Movie updatedMovie
    ) {
        this.movieService.updateMovie(updatedMovie, movieId);
    }

}