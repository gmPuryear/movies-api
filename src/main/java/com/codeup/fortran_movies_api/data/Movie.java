package com.codeup.fortran_movies_api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String year;
    private String plot;
    private String poster;
    private String rating;

    @ManyToOne // Many movies have the same director
    @JsonIgnoreProperties("directedMovies")
    private Director director; // from movies side we have a many to one relationship because you can have one
    // director with many movies. ** Also, this director is reflective of the director_id foreign key
//    private String actors;
//    private String Poster;
//    private String genre;

    //    ----- Creating many to many relationship for genres-----
    @ManyToMany(mappedBy = "movies")
//  keeps Jackson from making a list of genres with a list of movies with a list of genres with a list of movies...
    @JsonIgnoreProperties("movies")
    private List<Genre> genres;

    //    ----- ManyToMany for actors -----
    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties("movies")
    private List<Actor> actors;

    public Movie(int id, String title, String year, String director, String actors, String imdbId, String genre, String plot, String poster, String rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.plot = plot;
        this.poster = poster;
        this.rating = rating;
    }

    public Movie() { // empty constructor

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    // genre getter
    public List<Genre> getGenres() {
        return genres;
    }
    // genre setter
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    // actor getter
    public List<Actor> getActors() {
        return actors;
    }
    // actor setter
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", director=" + director.getName() +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
