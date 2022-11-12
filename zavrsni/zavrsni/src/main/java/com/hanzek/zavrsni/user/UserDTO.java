package com.hanzek.zavrsni.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDTO {


    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private Set<String> authorities;

    
//    
//    public UserDTO() {
//		super();
//	}


	public UserDTO(Integer id, String username, String firstName, String lastName, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
    }
    

    public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Set<String> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}


	@Override
    public String toString(){
        return "UserDTO{"+
                "Ime= "+ firstName + '\'' +
                ", Prezime= " + lastName +
                '}';
    }



}
