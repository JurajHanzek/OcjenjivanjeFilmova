package com.hanzek.zavrsni.beans;

public class MovieStudio {

	private Long idMovie_studio;
	private String name;
	private String image;
	
	
	
	public MovieStudio() {
		super();
	}
	public MovieStudio(Long idMovie_studio, String name, String image) {
		super();
		this.idMovie_studio = idMovie_studio;
		this.name = name;
		this.image = image;
	}
	public Long getIdMovie_studio() {
		return idMovie_studio;
	}
	public void setIdMovie_studio(Long idMovie_studio) {
		this.idMovie_studio = idMovie_studio;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
