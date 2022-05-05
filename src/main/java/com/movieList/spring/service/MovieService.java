package com.movieList.spring.service;

import com.movieList.spring.errorHandling.ErrorResponse;
import com.movieList.spring.models.Movie;
import com.movieList.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  // @route   GET '/api/v1/movies'
  // @desc    list all movies
  // @access  public
  public Object getMovies(HttpServletResponse res) {
    // get movies from database
    List<Movie> movies = movieRepository.getAllMovies();

    // check if movies exists
    if(movies.isEmpty()) {
      res.setStatus(404);
      return new ErrorResponse(404, "there's no such movies found");
    }

    res.setStatus(200);
    return movies;
  }

  // @route   GET '/api/v1/movies/{id}'
  // @desc    get one movie by id
  // @access  public
  public Object getOneMovie(HttpServletResponse res, String id) {

    Long longId = Long.parseLong(id);
    Movie movie = movieRepository.getOneMovie(longId);

    if(movie == null) {
      res.setStatus(404);
      return new ErrorResponse(
        404,
        "there's no such movie found with given id");
    }

    res.setStatus(200);
    return movie;
  }
}
