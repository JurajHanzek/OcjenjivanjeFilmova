package com.hanzek.zavrsni.beans;

public class Ocjene {
	private Long idMovie;
	private Double rating;
	private Double imdbRating;
	private Double metacriticRating;
	private Double rottenRating;
	
	
	public Ocjene() {
		super();
	}
	public Ocjene(Long idMovie, Double rating, Double imdbRating, Double metacriticRating, Double rottenRating) {
		super();
		this.idMovie = idMovie;
		this.rating = rating;
		this.imdbRating = imdbRating;
		this.metacriticRating = metacriticRating;
		this.rottenRating = rottenRating;
	}
	public Long getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public Double getMetacriticRating() {
		return metacriticRating;
	}
	public void setMetacriticRating(Double metacriticRating) {
		this.metacriticRating = metacriticRating;
	}
	public Double getRottenRating() {
		return rottenRating;
	}
	public void setRottenRating(Double rottenRating) {
		this.rottenRating = rottenRating;
	}
	
	

}
