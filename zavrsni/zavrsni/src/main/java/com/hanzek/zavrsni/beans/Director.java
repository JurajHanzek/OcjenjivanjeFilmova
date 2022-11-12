package com.hanzek.zavrsni.beans;

public class Director {

	private Long idDirector;
	private String name;
	private String lastName;
	private String dateOfBirth;
	private String image;
	
	public Director() {}
	public Director(Long idDirector, String name, String lastName, String dateOfBirth,
			String image) {
		super();
		this.idDirector = idDirector;
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.image = image;
	}
	public Long getIdDirector() {
		return idDirector;
	}
	public void setIdDirector(Long idDirector) {
		this.idDirector = idDirector;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
