package com.movieList.spring.service;

import com.movieList.spring.errorHandling.ErrorHandler;
import com.movieList.spring.errorHandling.ErrorResponse;
import com.movieList.spring.models.Movie;
import com.movieList.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class MovieService {
  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  // @route   GET '/api/v1/movies'
  // @desc    list all movies
  // @access  public
  public Object getMovies(HttpServletResponse res) {
    List<Movie> movies = null;
    try {
      // get movies from database
      movies = movieRepository.getAllMovies();

      // check if movies exists
      if(movies.isEmpty()) {
        res.setStatus(404);
        return new ErrorResponse(404, "there's no such movies found");
      }

    } catch (Exception err) {
      return ErrorHandler.handle(err, res);
    }

    return movies;
  }
}
