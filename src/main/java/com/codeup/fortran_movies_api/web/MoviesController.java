package com.codeup.fortran_movies_api.web;

import data.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin //this is to help with local dev testing
@RestController
//registers the class with Spring's Dependency Injector (more on that later) and is handled in particular ways.
//  Among those ways is the elimination of a need to annotate every controller method with @ResponseBody.
//Most importantly, @RestController allows us to signify that a controller exists for the purpose of sending/receiving data.

@RequestMapping(value = "/api/movies", headers = "Accept=application/json")
//annotation that we are informing Spring of how to direct requests to MoviesController, as well as what type of data is accepted
//this is like a mail delivery that tells to send mail to a certain neighborhood
//and later will route requests to specific methods in a class likf from neighborhood to a specific home
//From api/movies, we can further define what requests go to which methods.
//i.e., GET requests on api/movies go to the method annotated with @GetMapping.
//and DELETE requests on api/movies/{id} go to @DeleteMapping("{id}").
//!!! 🧐 Serialization/Deserialization in Spring Using Spring, we do not need to convert objects to and from JSON with another dependency.
public class MoviesController {

    private List<Movie> sampleMovies = setMovies();

    //    @GetMapping // is called a *composed annotation*. Meaning, its behaviors are composed of the actions of other annotations.
//      `@GetMapping` acts as a shortcut for`@RequestMapping(method = RequestMethod.GET)`.
//       To use it, simply place @GetMapping over your desired REST controller method:
//    @GetMapping
//    private List<Movie> getAll() {
//        ...
//    }
//    From this point, any valid GET request sent to /api/movies will be routed to getAll().
    // when typed in correct URL it will download all movies
    @GetMapping("all")
    public List<Movie> getAll() {
        return sampleMovies;
    }

    @GetMapping
    public Movie one() {
        return sampleMovies.get(1);
    }

    @GetMapping("{id}") // Define the path variable to use here
    public Movie getById(@PathVariable int id) { // Actually use the path variable here by annotating a parameter with @PathVariable
        return sampleMovies.stream().filter((movie) -> {
                    return movie.getId() == id; // filter out non-matching movies
                })
                .findFirst() // isolate to first match
                .orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
    }

    @PostMapping
    public void create(@RequestBody Movie movie){
        // add one movie to our movies list (fake db)
        sampleMovies.add(movie);
    }

    @PostMapping("all")
    public void createAll(@RequestBody List<Movie> moviesToAdd) {
        sampleMovies.addAll(moviesToAdd);
    }

    private List<Movie> setMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(
                1,
                "The Matrix",
                "1999",
                "Lana Wachowski",
                "Keanu Reeves",
                "https://www.imdb.com/title/tt0133093/",
                "Action",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence."
        ));
        movies.add(new Movie(
                2,
                "A New Hope",
                "1980",
                "Lana Wachowski",
                "Keanu Reeves",
                "https://www.imdb.com/title/tt0076759/",
                "Action",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence."
        ));
        movies.add(new Movie(
                3,
                "snatch",
                "Guy Ritchie",
                "2000",
                "Brad Pitt",
                "https://www.imdb.com/title/tt0208092/",
                "action",
                "Unscrupulous boxing promoters, violent bookmakers, a Russian gangster, incompetent amateur robbers and supposedly Jewish jewelers fight to track down a priceless stolen diamond."
        ));
        return movies;
    }


}
