package com.hanzek.zavrsni.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie {
	
	private Long idMovie;
	private String title; 
	private String releaseyear;
	private String synopsis;
	private String trailerUrl;
	private Integer durationMin;
	private Long directorId;
	private String rated;
	private String image;
	private Long idgenre;
	private Long movieStudioid;
	
	
	public Movie(Long idMovie, String title, String releaseyear, String synopsis, String trailerUrl,
			Integer durationMin, Long directorId, String rated, String image, Long idgenre, Long movieStudioid) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.releaseyear = releaseyear;
		this.synopsis = synopsis;
		this.trailerUrl = trailerUrl;
		this.durationMin = durationMin;
		this.directorId = directorId;
		this.rated = rated;
		this.image = image;
		this.idgenre = idgenre;
		this.movieStudioid = movieStudioid;
	}

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(String releaseyear) {
		this.releaseyear = releaseyear;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public Integer getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(Integer durationMin) {
		this.durationMin = durationMin;
	}

	public Long getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Long directorId) {
		this.directorId = directorId;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getIdgenre() {
		return idgenre;
	}

	public void setIdgenre(Long idgenre) {
		this.idgenre = idgenre;
	}

	public Long getMovieStudioid() {
		return movieStudioid;
	}

	public void setMovieStudioid(Long movieStudioid) {
		this.movieStudioid = movieStudioid;
	}

	
//	public Movie() {}
//	
//	

}
