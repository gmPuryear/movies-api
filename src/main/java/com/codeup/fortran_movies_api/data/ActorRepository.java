package com.codeup.fortran_movies_api.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository <Actor, Integer>  {

    List<Actor> findByName(String name);

}
