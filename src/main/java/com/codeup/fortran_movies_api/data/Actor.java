package com.codeup.fortran_movies_api.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {

    //    ----- Fields for actors table -----
    @Id // says that the id is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "movie_actor",
            joinColumns =
            @JoinColumn(name = "actor_id", referencedColumnName = "id"),// Join the movies table and actors table with the associative table movie_actor
            inverseJoinColumns =
            @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )

//    ----- bring in movies list -----
    private List<Movie> movies;

//    ----- CONSTRUCTOR -----
    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }
//----- EMPTY CONSTRUCTOR -----
    public Actor() {

    }

    //    ----- Getters and Setters -----
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    ----- NEEDS GET MOVIES() TO GET JACSON TO SERIALIZE LIST OF MOVIES TURNS INTO BASICALLY TURNS IT INTO USER LE INFO-----
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
