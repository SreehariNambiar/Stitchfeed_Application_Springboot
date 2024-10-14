package com.example.demo.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Clips;
import com.example.demo.models.User;
import com.example.demo.repository.ClipsRepository;

@Service
public class ClipsServiceImplementation implements ClipsService{
	
	@Autowired
	private ClipsRepository clipsRepository;
	
	@Autowired
	private UserService userService;
	
	

	@Override
	public Clips createClip(Clips clip, User user) {
		// TODO Auto-generated method stub
		Clips createClip = new Clips();
		
		createClip.setTitle(clip.getTitle());
		createClip.setVideo(clip.getVideo());
		createClip.setUser(user);
		return clipsRepository.save(createClip);
	}

	@Override
	public List<Clips> findAllClips() {
		// TODO Auto-generated method stub
		return clipsRepository.findAll();
	}

	@Override
	public List<Clips> findUsersClip(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		userService.findUserById(userId);
		return clipsRepository.findByUserId(userId);
	}

}
