package com.movieList.spring.repository;

import com.movieList.spring.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

  // @route   GET '/api/v1/movies'
  @Query(value = "SELECT * FROM movie;", nativeQuery = true)
  List<Movie> getAllMovies();

  // @route   GET '/api/v1/movies/{id}'
  @Query(value = "SELECT * FROM movie WHERE id = ?1", nativeQuery = true)
  Movie getOneMovie(Long id);
}
