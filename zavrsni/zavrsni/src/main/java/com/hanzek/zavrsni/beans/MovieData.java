package com.hanzek.zavrsni.beans;

public class MovieData {
	
	private String idImdb;
	private String title;
	private String year;
	private String genre;
	
	
	
	
	public MovieData() {
		super();
	}
	public MovieData(String idImdb, String title, String year, String genre) {
		super();
		this.idImdb = idImdb;
		this.title = title;
		this.year = year;
		this.genre = genre;
	}
	public String getIdImdb() {
		return idImdb;
	}
	public void setIdImdb(String idImdb) {
		this.idImdb = idImdb;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	

}
