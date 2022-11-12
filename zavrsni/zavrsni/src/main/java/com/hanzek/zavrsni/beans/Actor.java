package com.hanzek.zavrsni.beans;

public class Actor {

	private Long idActors;
	private String name;
	private String lastName;
	private String dateOfBirth;
	private String nationality;
	private String image;
	private String info;
	
	
	public Actor() {}
	
	public Actor(Long idActors, String name, String lastName, String dateOfBirth, String nationality, String image,
			String info) {
		super();
		this.idActors = idActors;
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.image = image;
		this.info = info;
	}

	public Long getIdActors() {
		return idActors;
	}
	public void setIdActors(Long idActors) {
		this.idActors = idActors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getIdCountry() {
		return nationality;
	}
	public void setIdCountry(String nationality) {
		this.nationality = nationality;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	
}
