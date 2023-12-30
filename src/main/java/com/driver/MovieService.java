package com.driver;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

	MovieRepository movieRepo=new MovieRepository();
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepo.addMovie(movie);
	}
	public void addDirector(Director director) {
		// TODO Auto-generated method stub
		movieRepo.addDirector(director);
	}
	public void addMovieDirectorPair(String movieName, String directorName) {
		// TODO Auto-generated method stub
		movieRepo.addMovieDirectorPair(movieName,directorName);
	}
	public Movie getMovieByName(String movieName) {
		// TODO Auto-generated method stub
		 return movieRepo.getMovieByName(movieName);
	}
	public Director getDirectorByName(String directorName) {
		// TODO Auto-generated method stub
		return movieRepo.getDirectorByName(directorName);
	}
	public ArrayList<String> getMoviesByDirectorName(String directorName) {
		// TODO Auto-generated method stub
		return movieRepo.getMoviesByDirectorName(directorName);
	}
	public ArrayList<String> findAllMovies() {
		// TODO Auto-generated method stub
		return movieRepo.findAllMovies();
	}
	public void deleteDirectorByName(String directorName) {
		// TODO Auto-generated method stub
		movieRepo.deleteDirectorByName(directorName);
	}
	public void deleteAllDirectors() {
		// TODO Auto-generated method stub
		movieRepo.deleteAllDirectors();
	}
	
    
}
