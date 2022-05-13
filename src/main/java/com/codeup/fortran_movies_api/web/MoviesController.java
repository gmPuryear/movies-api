// CRUD: CREATE, READ, UPDATE, and DELETE. Are basic operations that can be performed on database applications
// REST: Representational State Transfer. is a popular architectural style for software, especially web APIs.
//      It’s defined by five design constraints that, when followed, produce an application with specific properties,
//      including performance, simplicity, and reliability.
package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin //this is to help with local dev testing... And trying to get info from another URL
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
    private final MovieRepository movieRepository;
    private final DirectorsRepository directorsRepository;
    private final ActorRepository actorRepository;

    public MoviesController(MovieRepository movieRepository, DirectorsRepository directorsRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.directorsRepository = directorsRepository;
        this.actorRepository = actorRepository;
    }

//    From this point, any valid GET request sent to /api/movies will be routed to getAll().
    // when typed in correct URL it will download all movies
    // TODO: put the expected path out to the side of the method annotation
    //  -> this helps to keep track so we don't have to guess if methods conflict on the same path
    @GetMapping("all") // /api/movies/all
    public List<Movie> getAll() {
        return movieRepository.findAll(); //findAll() will return a list of objects and is provided by the JpaRepository
    }

    @GetMapping("{id}") // Define the path variable to use here
    public Movie getById(@PathVariable int id) { // Actually use the path variable here by annotating a parameter with @PathVariable
        return movieRepository.findById(id).orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
    }

    @GetMapping("search") // /api/movies/search?title=<movieTitle>
    public List<Movie> getByTitle(@RequestParam("title") String title) { // requestParam is
        // TODO: we need to create the findByTitle() method in our MoviesRepository - magic!
        return movieRepository.findByTitle(title);
    }

    @GetMapping("search/year") // api/movies/search/year
    public List<Movie> searchByYearRange (@RequestParam("startYear") int startYear, @RequestParam("endYear") int endYear) {
        // requestParam is for multiple things to GET
        // TODO: @RequestParam expects a query parameter in the request URL
        //  to have a param matching what is in the annotation (ie: @RequestParam("startYear"))
        return movieRepository.findByYearRange(startYear, endYear);
    }

    @GetMapping("search/director")
    public List<Director> getByDirector(@RequestParam("name") String directorName) {
        return directorsRepository.findByName(directorName);
    }

    @GetMapping("search/actor")
    public List<Actor> findByName(@RequestParam("name") String actorName) {
        return actorRepository.findByName(actorName);
    }

    @PostMapping
    public void create(@RequestBody Movie movie) {
        // add one movie to our movies list (fake db)
        movieRepository.save(movie);
    }

    @PostMapping("all") // /api/movies/all
    // must add @RequestBody in order for the createAll method to actually get the list of movies
    public void createAll(@RequestBody List<Movie> moviesToAdd) {
        movieRepository.saveAll(moviesToAdd);
    }



    @DeleteMapping("{id}") // api
    public void deleteByID(@PathVariable int id) {
        try {
            movieRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Matching movie with ID " + id);
        }
    }

}
