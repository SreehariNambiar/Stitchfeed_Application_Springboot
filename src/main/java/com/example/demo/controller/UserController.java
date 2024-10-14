package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.exceptions.UserException;
import com.example.demo.models.User;

import com.example.demo.repository.UserRepository;
import com.example.demo.sevices.UserService;


@RestController // we are defining the controller annotation so that we can define varipus end points of our API like get put post delete.
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
//	@PostMapping("/users")
//	public User createUser(@RequestBody User user) {
//		User newUser = new User();
//		newUser.setEmail(user.getEmail());
//		newUser.setFirstName(user.getFirstName());
//		newUser.setLastName(user.getLastName());
//		newUser.setPassword(user.getPassword());
//		newUser.setId(user.getId());
//		
//		User savedUser = userRepository.save(newUser);
		
//		User savedUser = userService.registerUser(user);
//		
//		
//		return savedUser;
//	}
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
//		List<User> users= new ArrayList<>();
//		User user1 = new User(1,"code", "genie", "genie@google.com", "12345");
//		User user2 = new User(2,"ram", "arora", "ram@google.com", "12345");
//		users.add(user1);
//		users.add(user2);
//		return users;
		List<User> users = userRepository.findAll();
		
		return users;
	}
	
	@GetMapping("/api/users/{userId}")
	public User getUserByid(@PathVariable("userId") Integer id) throws UserException {
//		List<User> users= new ArrayList<>();
//		User user1 = new User(1,"code", "genie", "genie@google.com", "12345");
//		user1.setId(id);
//		
//		
//		return user1;
		
	//	Optional<User> user = userRepository.findById(id);//optional means user can be or not be there thats why no user class like User user = userRepository.findById(id);
	//	if(user.isPresent() /* another optional method */) {
	//		return user.get(); //get is a method of optional to get the value Optional<Value> name of the variable.
			
		//}
		
		//throw new Exception("user not exist with userid " + id);
		
		User user = userService.findUserById(id);
		
		return user;
		
		
		
		
	}
	
	@PutMapping("/api/users")
	public User updateUser(@RequestHeader("Authorization") String jwt, @RequestBody User user) throws UserException {
		
		//We can't use the below one as any user can update any user's information if they want if they give the user id so to make it more secure we are giving it to the above;
//	@PutMapping("/api/users/{userId}")
//	public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception {
//		Optional<User> user1 = userRepository.findById(userId);
//		
//		if(user1.isEmpty()) {
//			throw new Exception("user not exist with user id " + userId);
//			
//		}
//		
//		User oldUser = user1.get();
		
		
//		User user1 = new User(1,"code", "genie", "genie@google.com", "12345");
		
//		if(user.getFirstName()!=null) {
//			user1.setFirstName(user.getFirstName());
//		}
//		
//		if(user.getLastName()!=null) {
//			user1.setLastName(user.getLastName());
//		}
//		if(user.getEmail()!=null) {
//			user1.setLastName(user.getEmail());
//		}
		
//		if(user.getId()!=null) {
//			user1.setId(user.getId());
//		}
//		if(user.getPassword()!=null) {
//			user1.setPassword(user.getPassword());
//		}
//		return user1;
		
		
//		if(user.getFirstName()!=null) {
//			oldUser.setFirstName(user.getFirstName());
//		}
//		
//		if(user.getLastName()!=null) {
//			oldUser.setLastName(user.getLastName());
//		}
//		if(user.getEmail()!=null) {
//			oldUser.setEmail(user.getEmail());
//		}
//		
//		User updatedUser = userRepository.save(oldUser); // to save it back in the database
//		return updatedUser;
		User reqUser = userService.findUserByJwt(jwt);
		User updatedUser = userService.updateUser(user, reqUser.getId());
		return updatedUser;

	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable Integer userId) throws UserException {
		
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserException("user not exist with user id " + userId);
			
		}
		
		userRepository.delete(user.get());
		return "user DELETED SUCCESSFULLY with id " + userId;
	}
	
//	@PutMapping("/users/follow/{userId1}/{userId2}")
	@PutMapping("/users/follow/{userId2}")
	public User followUserHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer userId2) throws UserException {
		User reqUser = userService.findUserByJwt(jwt); 
		User user = userService.followUser(reqUser.getId(), userId2);
		return user;
	}
	
	@GetMapping("/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users = userService.searchUser(query);
		return users;
		
	}
	
	@GetMapping("/api/users/profile")
	public User getuserFromToken(@RequestHeader("Authorization") String jwt) {
//		System.out.println("jwt   -------------  "+jwt);
		
		User user = userService.findUserByJwt(jwt);
		user.setPassword(null); //to not send the password to the front end;
		return user;
	}
}


;