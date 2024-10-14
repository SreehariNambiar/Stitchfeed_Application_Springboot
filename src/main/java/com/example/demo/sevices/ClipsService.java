package com.example.demo.sevices;

import java.util.List;

import com.example.demo.models.Clips;
import com.example.demo.models.User;

public interface ClipsService {
	public Clips createClip(Clips clip, User user);
	
	public List<Clips> findAllClips();
	
	public List<Clips> findUsersClip(Integer userId) throws Exception;
	
}
