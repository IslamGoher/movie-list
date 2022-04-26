package com.movieList.spring.models;

import javax.persistence.*;

@Table(name = "movie")
@Entity(name = "Movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "year")
  private int year;

  @Column(name = "is_watched")
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
