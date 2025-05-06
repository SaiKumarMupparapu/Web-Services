package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.User;

@RestController
public class UserController {
	@DeleteMapping(value="/delete/user",produces = "text/plain")
	public ResponseEntity<String> deleteUser(@RequestParam("id") int id){
		//updating DB logic		
		return new ResponseEntity<>("user Deleted", HttpStatus.OK);
	}
	
	
	@PutMapping(value="/update/{id}",produces = "text/plain" )
	public ResponseEntity<String> updateUser(@PathVariable("id") int id){
		//updating DB logic		
		return new ResponseEntity<>("user Updated", HttpStatus.OK);
	}
	
	@PostMapping(
			value = "/register",
			consumes = "application/json",
			produces = "text/plain"
			)
	public ResponseEntity<String> registerUser(@RequestBody User user) {
		
		return new ResponseEntity<String>
		("user Registration successful",HttpStatus.CREATED);
	}

	@GetMapping("/user/{name}")
 	public String greetMSgUserName(@PathVariable("name") String name) {
		return name + ",welcome to dashboard";
	}

	@GetMapping("/UserDetail")
	public String greetMSgUserNameAge(@RequestParam("name") String name, @RequestParam("age") int age) {
		return "User Name :" + name + "\n Age :" + age;
	}
	
	@GetMapping(value = "/user", produces="appliction/json")
	public User getUser() {
		return new User("sai", 23);

	}

	@GetMapping(value = "/users", produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() {
		User u1 = new User("sai", 23);
		User u2 = new User("swaraj", 25);
		User u3 = new User("kumar", 35);
		User u4 = new User("naveen", 18);

		List<User> list = Arrays.asList(u1, u2, u3, u4);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}
}
