package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// the "<Genre>" is just the Genre entity/class
public interface GenresRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByGenre(String name);
}
