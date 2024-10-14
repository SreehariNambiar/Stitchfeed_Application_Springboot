package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.tool.schema.internal.exec.GenerationTarget;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String chat_name;
	
	private String chat_image;
	
	@ManyToMany //many users can create many chat with many people.
	private List<User> users = new ArrayList<>(); 
	
	private LocalDateTime timestamp;
	
	@OneToMany(mappedBy = "chat") //this won't create another table like message_chat
	private List<Message> messages = new ArrayList<>();
	
	
	
}
