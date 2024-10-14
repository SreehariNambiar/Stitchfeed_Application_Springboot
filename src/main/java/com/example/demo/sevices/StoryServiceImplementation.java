package com.example.demo.sevices;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Story;
import com.example.demo.models.User;
import com.example.demo.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService{
	
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Story createStory(Story story, User user) {
		// TODO Auto-generated method stub
		Story createdStory = new Story();
		createdStory.setCaptions(story.getCaptions());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimestamp(LocalDateTime.now());
		
		storyRepository.save(createdStory);
		
		return createdStory;
	}

	@Override
	public List<Story> findStoryByUserId(Integer userId) throws Exception {
		// TODO Auto-generated method stub
		User user = userService.findUserById(userId);
		return storyRepository.findByUserId(userId);
		
	}


}
