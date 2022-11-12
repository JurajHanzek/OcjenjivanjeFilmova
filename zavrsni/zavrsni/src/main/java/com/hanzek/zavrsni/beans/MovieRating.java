package com.hanzek.zavrsni.beans;

public class MovieRating {

	private Long idRating;
	private String komentar;
	private Long rating;
	private Long idMovie;
	private Long idUser;
	private Double imdbRating;
	private Double metacriticRating;
	private Double rottenRating;
	
	
	public MovieRating(Long idRating, String komentar, Long rating, Long idMovie, Long idUser, Double imdbRating,
			Double metacriticRating, Double rottenRating) {
		super();
		this.idRating = idRating;
		this.komentar = komentar;
		this.rating = rating;
		this.idMovie = idMovie;
		this.idUser = idUser;
		this.imdbRating = imdbRating;
		this.metacriticRating = metacriticRating;
		this.rottenRating = rottenRating;
	}
	public MovieRating() {
		super();
	}
	public Long getIdRating() {
		return idRating;
	}
	public void setIdRating(Long idRating) {
		this.idRating = idRating;
	}
	public String getKomentar() {
		return komentar;
	}
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	public Long getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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
