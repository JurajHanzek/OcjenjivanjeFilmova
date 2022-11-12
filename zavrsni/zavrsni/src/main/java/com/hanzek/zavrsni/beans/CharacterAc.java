package com.hanzek.zavrsni.beans;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CharacterAc {
	private Long idCharacter;
	private String name;
	private String info;
	private Long idMovie;
	
//	
//	public CharacterAc() {}
//	
//	


	public CharacterAc(Long idCharacter, String name, String info, Long idMovie) {
		super();
		this.idCharacter = idCharacter;
		this.name = name;
		this.info = info;
		this.idMovie = idMovie;
	}




	public Long getIdCharacter() {
		return idCharacter;
	}
	public void setIdCharacter(Long idCharacter) {
		this.idCharacter = idCharacter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Long getIdMovie() {
		return idMovie;
	} 
	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}

	
	
	
}
