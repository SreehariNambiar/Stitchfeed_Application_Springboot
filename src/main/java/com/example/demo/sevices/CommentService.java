package com.example.demo.sevices;

import java.util.List;

import com.example.demo.models.Comment;
import com.example.demo.models.Post;

public interface CommentService {

	public Comment createComment(Comment comment, Integer postId, Integer userId) throws Exception;
	
	public Comment likeComment(Integer commentId, Integer userId) throws Exception;
	
	public Comment findCommentById(Integer commentId) throws Exception;
	
	
		
		
		
	
}