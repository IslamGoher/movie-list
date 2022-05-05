package com.movieList.spring.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Table(name = "movie")
@Entity(name = "Movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  @Size(min = 1, message = "title is required")
  @NotNull(message = "title is required")
  private String title;

  @Column(name = "description")
  @Size(max = 1000, message = "description must be lower than 1000 character")
  private String description;

  @Column(name = "year")
  @Min(value = 1888, message = "year must be greater than or equal 1888")
  @NotNull(message = "year is required")
  private int year;

  @Column(name = "is_watched")
  @NotNull
  private boolean isWatched;

  public Movie() {}

  public Movie(String title, String description, int year, boolean isWatched) {
    this.title = title;
    this.description = description;
    this.year = year;
    this.isWatched = isWatched;
  }

  public Movie(Long id, String title, String description, int year, boolean isWatched) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.year = year;
    this.isWatched = isWatched;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public boolean isWatched() {
    return isWatched;
  }

  public void setWatched(boolean watched) {
    isWatched = watched;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", year=" + year +
            ", isWatched=" + isWatched +
            '}';
  }
}
