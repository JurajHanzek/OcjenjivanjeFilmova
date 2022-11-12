package com.hanzek.zavrsni.beans;

public class UserRating {
	
	private Long idRating;
	private String komentar;
	private Double rating;
	private Long idMovie;
	private Long idUser;
	
	
	public UserRating() {
		super();
	}
	public UserRating(Long idRating, String komentar, Double rating, Long idMovie, Long idUser) {
		super();
		this.idRating = idRating;
		this.komentar = komentar;
		this.rating = rating;
		this.idMovie = idMovie;
		this.idUser = idUser;
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
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
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
	
	

}
