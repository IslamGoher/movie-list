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

  // @route   POST '/api/v1/movies'
  @Query(
    value = "INSERT INTO movie(title, description, year, is_watched) VALUES(?1, ?2, ?3, ?4) RETURNING id;",
    nativeQuery = true
  )
  Long createMovie(String title, String description, int year, boolean isWatched);

  // @route   DELETE '/api/v1/movies/{id}
  @Query(value = "DELETE FROM movie WHERE id = ?1 RETURNING id;", nativeQuery = true)
  Long deleteMovie(Long id);

  // @route   PUT '/api/v1/movies/{id}
  @Query(value =
    "UPDATE movie " +
    "SET " +
      "title = ?1, " +
      "description = ?2, " +
      "year = ?3, " +
      "is_watched = ?4 " +
    "WHERE id = ?5 " +
    "RETURNING id;",
    nativeQuery = true)
  Long updateMovie(
    String title,
    String description,
    int year,
    boolean isWatched,
    Long id
  );

}
