package com.codeup.fortran_movies_api.web;

public class MovieDTO {
    //----- PROPERTIES -----
    private int id;
    private String title;
    private String actors;
    private String director;
    private String genre;
    private String year;
    private String poster;
    private String rating;
    private String plot;

//----- CONSTRUCTOR -----
    public MovieDTO(int id, String title, String actors, String director, String genre, String year, String poster, String rating, String plot) {
        this.id = id;
        this.title = title;
        this.actors = actors;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.poster = poster;
        this.rating = rating;
        this.plot = plot;
    }

    //----- GETTERS & SETTERS -----
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

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", actors='" + actors + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", poster='" + poster + '\'' +
                ", rating='" + rating + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
