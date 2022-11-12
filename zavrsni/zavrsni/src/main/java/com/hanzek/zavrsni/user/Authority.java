package com.hanzek.zavrsni.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="authority")
public class Authority implements Serializable {



    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;


    @Column(name = "name")
    private String name;


    @ManyToMany(targetEntity = User.class, mappedBy ="authorities")
    private List<User> users;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


    
}
