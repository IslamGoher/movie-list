package com.movieList.spring.controller;

import com.movieList.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

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
    return movieService.getMovies(res);
  }

}
