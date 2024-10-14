package com.example.demo.models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity //it maps the database table with this class
public class Post {
	
	@Id // this is to inform the database that this is our unique identifier.
	@GeneratedValue(strategy = GenerationType.AUTO) // this is to autogenerate uniue id's
	private Integer id;
	
	private String caption;
	private String image;
	private String video;
	
	@ManyToOne //one user can create many post
	private User user;
	
	private LocalDateTime createdAt;
	
	@OneToMany //many comments can exist in one post...
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany //one post have multiple user like......
	private List<User> liked = new ArrayList<>();
	
	
	public Post() {
		
	}
	

	




	public Post(Integer id, String caption, String image, String video, User user, LocalDateTime createdAt,
			List<Comment> comments, List<User> liked) {
		super();
		this.id = id;
		this.caption = caption;
		this.image = image;
		this.video = video;
		this.user = user;
		this.createdAt = createdAt;
		this.comments = comments;
		this.liked = liked;
	}







	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<User> getLiked() {
		return liked;
	}



	public void setLiked(List<User> liked) {
		this.liked = liked;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
