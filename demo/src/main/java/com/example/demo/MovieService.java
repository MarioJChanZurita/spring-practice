
package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private static final String COLLECTION = "action";
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    public void saveMovie(Movie movie) {
     if (movie != null) {
      this.mongoTemplate.insert(movie,COLLECTION);
     }
    }

    private MoviesRepository moviesRepository;

    public MovieService(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }

    /* public void saveMovie(Movie movie){
        this.moviesRepository.insert(movie);
    } */

    public List<Movie> getMovies(){
        return this.moviesRepository.findAll();
    }

    public Optional<Movie> getMovie(String id){
        return this.moviesRepository.findById(id);
    }

    public void deleteMovie(String id) {
        this.moviesRepository.deleteById(id);
    }

    public void updateMovie(Movie updatedMovie, String id) {
        Movie movie = this.moviesRepository.findById(id).orElse(null);
        movie = updatedMovie;
        this.moviesRepository.save(movie);
    }

}