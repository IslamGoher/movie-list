package com.movieList.spring.controller;

import com.movieList.spring.errorHandling.ErrorHandler;
import com.movieList.spring.errorHandling.ErrorResponse;
import com.movieList.spring.models.Movie;
import com.movieList.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class MovieController {
  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }



  // @route   GET '/api/v1/movies'
  // @desc    list all movies
  // @access  public
  @GetMapping(path = "/movies")
  public Object getMovies(HttpServletResponse res) {
    List<Movie> movies = null;

    try {
      // get movies from database
      movies = movieService.getMovies();

      // check if movies exists
      if(movies.isEmpty()) {
        res.setStatus(404);
        return new ErrorResponse(404, "there's no such movies found");
      }

    } catch (Exception err) {
      return ErrorHandler.handle(err, res);
    }

    // send response
    res.setStatus(200);
    return movies;
  }

}
