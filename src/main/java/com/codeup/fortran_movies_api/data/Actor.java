package com.codeup.fortran_movies_api.data;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class Actor {

    //    ----- Fields for actors table -----
    @Id // says that the id is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
        // Join the movies table and actors table with the associative table movie_actor


    //    ----- Getters and Setters -----
    public Actor(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
