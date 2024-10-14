package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.response.ApiResponse;
import com.example.demo.sevices.PostService;
import com.example.demo.sevices.UserService;

@RestController // this is to tell Java that we are building end points here
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createPost(@RequestHeader("Authorization") String jwt, @RequestBody Post post) throws Exception{
	// here we do not just specify the class as return type we give response entity because we can also return the status code as well. So whatever we are sending to the frontend we send it using response entity
		User reqUser = userService.findUserByJwt(jwt);
		Post createdPost = postService.createNewPost(post, reqUser.getId());
		return new ResponseEntity<>(createdPost, HttpStatus.ACCEPTED);
	}
	
//	@DeleteMapping("/post/{postId}/user/{userId}")
	@DeleteMapping("/api/post/{postId}")
	public ResponseEntity<ApiResponse> deletePost(@RequestHeader("Authorization") String jwt, @PathVariable Integer postId) throws Exception{
		User reqUser = userService.findUserByJwt(jwt);
		String message = postService.deletePost(postId, reqUser.getId());
		ApiResponse res = new ApiResponse(message, true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
	}
	
	@GetMapping("/api/post/{postId}")
	public ResponseEntity<Post> findPostByIdHandler(@PathVariable Integer postId) throws Exception{
		
		Post post = postService.findPostById(postId);
		
		return new ResponseEntity<Post>(post, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/api/post/user/{userId}")
	public ResponseEntity<List<Post>> findUserPost(@PathVariable Integer userId){
		
		List<Post> posts = postService.findPostByUserId(userId);
		
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
		
	}
	
	@GetMapping("/api/posts")
	public ResponseEntity<List<Post>> findAllPost(){
		
		List<Post> posts = postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
		
	}
	
//	@PutMapping("/post/save/{postId}/user/{userId}")
	@PutMapping("/api/post/save/{postId}")
	public ResponseEntity<Post> savedPostHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer postId) throws Exception{
		
		User reqUser = userService.findUserByJwt(jwt); // loggedin in user
		Post post = postService.savedPost(postId, reqUser.getId());
		
		return new ResponseEntity<Post>(post, HttpStatus.ACCEPTED);
	}
	
//	@PutMapping("/post/like/{postId}/user/{userId}")
	@PutMapping("/api/post/like/{postId}")
	public ResponseEntity<Post> likePostHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer postId) throws Exception{
		
		User reqUser = userService.findUserByJwt(jwt);
		Post post = postService.likePost(postId, reqUser.getId());
		
		return new ResponseEntity<Post>(post, HttpStatus.ACCEPTED);
	}
	
	
	
	
}
