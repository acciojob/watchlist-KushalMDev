package com.driver;

public class Movie {
	String name;
	int durationInMinutes;
	double imdbRating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	public double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public Movie(String name, int durationInMinutes, double imdbRating) {
		super();
		this.name = name;
		this.durationInMinutes = durationInMinutes;
		this.imdbRating = imdbRating;
	}
	public Movie() {
		super();
	}
	
}
