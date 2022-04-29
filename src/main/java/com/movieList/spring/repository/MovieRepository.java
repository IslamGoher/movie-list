package com.movieList.spring.repository;

import com.movieList.spring.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  // @route   GET '/api/v1/movies'
  @Query(value = "select * from movie;", nativeQuery = true)
  List<Movie> getAllMovies();
}
