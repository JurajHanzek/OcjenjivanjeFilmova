package com.hanzek.zavrsni.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(targetEntity = Authority.class)
    @JoinTable(
            name ="user_authority",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="authority_id")}
    )
    //private List<Authority> authorities;
    private Set <Authority> authorities;



//    public User() {
//		super();
//	}



	public User(String username, String password, String firstName, String lastName) {
        this.username =username;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;

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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	public Set<Authority> getAuthorities() {
		return authorities;
	}



	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

    

}
