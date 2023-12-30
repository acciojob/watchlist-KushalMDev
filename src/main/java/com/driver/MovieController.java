package com.driver;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    
	MovieService movieService=new MovieService();
	
	@PostMapping("/add-movie")
	public ResponseEntity<String> addMovie(@RequestBody Movie movie){
		movieService.addMovie(movie);
		return new ResponseEntity<String>("Movie added successfully",HttpStatus.CREATED);
	}
	@PostMapping("/add-director")
	public ResponseEntity<String> addDirector(@RequestBody Director  director ){
		movieService.addDirector(director);
		return new ResponseEntity<String>("Director added successfully",HttpStatus.CREATED);
	}
	@PostMapping("/add-movie-director-pair")
	public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName ){
		movieService.addMovieDirectorPair(movieName,directorName);
		return new ResponseEntity<String>("Movie-Director pair added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("/get-movie-by-name/{name}")
	public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
		Movie movie=movieService.getMovieByName(movieName);
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-director-by-name/{name}")
	public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
		Director director=movieService.getDirectorByName(directorName);
		return new ResponseEntity<>(director,HttpStatus.CREATED);
	}
	@GetMapping("/get-movies-by-director-name/{director}")
	public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathVariable String directorName){
		ArrayList<String> list=movieService.getMoviesByDirectorName(directorName);
		return new ResponseEntity<>(list,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-movies")
	public ResponseEntity<ArrayList<String>> findAllMovies(){
		ArrayList<String> list=movieService.findAllMovies();
		return new ResponseEntity<>(list,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete-director-by-name")
	public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){
		movieService.deleteDirectorByName(directorName);
		return new ResponseEntity<String>("Movie-Director pair deleted successfully",HttpStatus.CREATED);
	}
	@DeleteMapping("/delete-all-directors")
	public ResponseEntity<String> deleteAllDirectors(){
		movieService.deleteAllDirectors();
		return new ResponseEntity<String>("All Movie-Director pair deleted successfully",HttpStatus.CREATED);
	}
	
	
}
