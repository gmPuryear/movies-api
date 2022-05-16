package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // TODO: Spring Data is pretty neat in that it reads your method name and interprets how to build the actual implementation of the query!
    List<Movie> findByTitle(String title); // findBy as a prefix indicates query on a column(s) -> -Title indicates the column on which to query -> String title is the param to use for the query
    // If a query could possibly return more than one object, you should probably account for that by having the return type of your method be a List<T>

// TODO: If your query gets more complex, you could use the @Query annotation!
    @Query(nativeQuery = true, // nativeQuery = true indicates that you want to write raw SQL
            value = "SELECT * FROM movies_db.movies m WHERE m.year >= ? AND m.year <= ?;") // question marks (?) indicate that Spring should draw the actual value from your method parameters
    List<Movie> findByYearRange(Integer startYear, Integer endYear); // Order matters!
}
