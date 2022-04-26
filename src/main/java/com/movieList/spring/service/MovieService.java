package com.movieList.spring.service;

import com.movieList.spring.models.Movie;
import com.movieList.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  // @route   GET '/api/v1/movies'
  public List<Movie> getMovies() {
    return movieRepository.getAllMovies();
  }
}
