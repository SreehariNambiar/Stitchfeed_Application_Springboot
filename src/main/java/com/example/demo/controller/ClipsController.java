package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Clips;
import com.example.demo.models.User;
import com.example.demo.sevices.ClipsService;
import com.example.demo.sevices.UserService;

@RestController
public class ClipsController {
	
	@Autowired
	private ClipsService clipsService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/clips")
	private Clips createClips(@RequestBody Clips clip, @RequestHeader("Authorization") String jwt) {
		
		User reqUser = userService.findUserByJwt(jwt);
		
		Clips createdClips = clipsService.createClip(clip, reqUser);
		
		return createdClips;
	}
	
	@GetMapping("/api/clips")
	private List<Clips> findAllClips() {
		
		List<Clips> clips = clipsService.findAllClips();
		
		return clips;
	}
	
	@GetMapping("/api/clips/user/{userId}")
	private List<Clips> findUsersClips(@PathVariable Integer userId) throws Exception {
		
		List<Clips> clips = clipsService.findUsersClip(userId);
		
		return clips;
	}
}
