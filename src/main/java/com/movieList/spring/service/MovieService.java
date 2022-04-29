package com.movieList.spring.service;

import com.movieList.spring.errorHandling.ErrorHandler;
import com.movieList.spring.errorHandling.ErrorResponse;
import com.movieList.spring.models.Movie;
import com.movieList.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

  // @route   GET '/api/v1/movies/{id}'
  // @desc    get one movie by id
  // @access  public
  public Object getOneMovie(HttpServletResponse res, String id) {
    Movie movie = null;

    try {
      Long longId = Long.parseLong(id);
      movie = movieRepository.getOneMovie(longId);

      if(movie == null) {
        return new ErrorResponse(
                404,
                "there's no such movie found with given id");
      }

    } catch (Exception err) {
      return ErrorHandler.handle(err, res);
    }

    return movie;
  }
}
