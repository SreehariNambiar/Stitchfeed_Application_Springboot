package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity //class annotation for database;
@Table(name="stitch") // if we want a different name from that of the class
public class User {
	
	@Id //gives unique identifier
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Integer id;
//	@Column(name="my_name") // to change the name of the column
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<Integer> following = new ArrayList<>();
	private List<Integer> followers = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany //many users can save many posts 
	private List<Post> savedPost = new ArrayList<>();
	
	private String gender;
	public User() {
		//Todo Auto-generated constructor stub
		
	}



	
	


	public List<Post> getSavedPost() {
		return savedPost;
	}







	public void setSavedPost(List<Post> savedPost) {
		this.savedPost = savedPost;
	}







	public List<Integer> getFollowing() {
		return following;
	}







	public void setFollowing(List<Integer> following) {
		this.following = following;
	}







	public List<Integer> getFollowers() {
		return followers;
	}







	public void setFollowers(List<Integer> followers) {
		this.followers = followers;
	}







	public String getGender() {
		return gender;
	}







	public void setGender(String gender) {
		this.gender = gender;
	}







	public User(Integer id, String firstName, String lastName, String email, String password, List<Integer> following,
			List<Integer> followers, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.following = following;
		this.followers = followers;
		this.gender = gender;
	}







	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
