package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Clips;
public interface ClipsRepository extends JpaRepository<Clips, Integer>{

	public List<Clips> findByUserId(Integer userId);
	
	
}
