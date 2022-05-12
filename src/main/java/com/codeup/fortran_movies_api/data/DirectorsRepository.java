package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// the "<Director>" is just the director entity/class
public interface DirectorsRepository extends JpaRepository<Director, Integer> {

    List<Director> findByName(String name);

}
