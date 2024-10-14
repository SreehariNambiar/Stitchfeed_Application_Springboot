package com.example.demo.sevices;

import java.util.List;

import com.example.demo.models.Story;
import com.example.demo.models.User;

public interface StoryService {
	
	public Story createStory(Story story, User user);
	
	public List<Story> findStoryByUserId(Integer userId) throws Exception;

}
