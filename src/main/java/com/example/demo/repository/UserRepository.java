//this is for accessing the database
package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.User;
//public interface UserRepository extends JpaRepository<ClassName, unique_Identifier_type>
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	//----------------------------string query
	
	@Query("select u from User u where u.firstName LIKE %:query% OR u.lastName LIKE %:query% OR u.email LIKE %:query%")
	public List<User> searchUser(@Param("query") String query);
}
