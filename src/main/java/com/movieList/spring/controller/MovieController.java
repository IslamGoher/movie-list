package com.movieList.spring.controller;

import com.movieList.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping(path = "/api/v1")
public class MovieController {

  @Autowired
  private MovieService movieService;

  // @route   GET '/api/v1/movies'
  // @desc    list all movies
  // @access  public
  @GetMapping(path = "/movies")
  public Object getMovies(HttpServletResponse res) {
    return movieService.getMovies(res);
  }

  // @route   GET '/api/v1/movies/{id}'
  // @desc    get one movie by id
  // @access  public
  @GetMapping(path = "/movies/{id}")
  public Object getOneMovie(
    HttpServletResponse res,
    @PathVariable(value = "id", required = true)
      @Positive(message = "id must be an integer greater than 0") String id
  ) {

    return movieService.getOneMovie(res, id);
  }

}
