package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query("select p from Post p where p.user.id=:userId") // if this query is true then return the list of Post by that id
	List<Post> findPostByUserId(Integer userId);

}
