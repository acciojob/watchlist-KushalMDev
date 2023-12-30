package com.driver;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

	HashMap<String,Movie> movieMap=new HashMap<>();
	HashMap<String,Director> directorMap=new HashMap<>();
	HashMap<String,ArrayList<String>> movieDirectorMap=new HashMap<>();
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieMap.put(movie.getName(), movie);
	}
	public void addDirector(Director director) {
		// TODO Auto-generated method stub
		directorMap.put(director.getName(), director);
	}
	public void addMovieDirectorPair(String movieName, String directorName) {
		// TODO Auto-generated method stub
		if(movieMap.containsKey(movieName)&&directorMap.containsKey(directorName)) {
			ArrayList<String> list=movieDirectorMap.getOrDefault(directorName, new ArrayList<>());
			list.add(movieName);
			movieDirectorMap.put(directorName, list);
			Director director=directorMap.get(directorName);
			int no=director.getNumberOfMovies();
			no++;
			director.setNumberOfMovies(no);
		}
	}
	public Movie getMovieByName(String movieName) {
		// TODO Auto-generated method stub
		if(movieMap.containsKey(movieName)) {
			return movieMap.get(movieName);
		}
		return null;
	}
	public Director getDirectorByName(String directorName) {
		// TODO Auto-generated method stub
		if(directorMap.containsKey(directorName)) {
			return directorMap.get(directorName);
		}
		return null;
	}
	public ArrayList<String> getMoviesByDirectorName(String directorName) {
		// TODO Auto-generated method stub
		ArrayList<String> result=new ArrayList<>();
		
		if(movieDirectorMap.containsKey(directorName)) {
			return movieDirectorMap.get(directorName);
		}
		return result;
	}
	public ArrayList<String> findAllMovies() {
		// TODO Auto-generated method stub
		ArrayList<String> result=new ArrayList<>();
		
		for(String key:movieMap.keySet()) {
			result.add(key);
		}
		return result;
	}
	public void deleteDirectorByName(String directorName) {
		// TODO Auto-generated method stub
		if(directorMap.containsKey(directorName)) {
			directorMap.remove(directorName);
		}
		if(movieDirectorMap.containsKey(directorName)) {
			for(String movieName:movieDirectorMap.get(directorName)) {
				movieMap.remove(movieName);
			}
			movieDirectorMap.remove(directorName);
		}
	}
	public void deleteAllDirectors() {
		// TODO Auto-generated method stub
		directorMap.clear();
		for(String directorName:movieDirectorMap.keySet()) {
			for(String movieName:movieDirectorMap.get(directorName)) {
				movieMap.remove(movieName);
			}
		}
		movieDirectorMap.clear();
	}
	
	
	
    
}
