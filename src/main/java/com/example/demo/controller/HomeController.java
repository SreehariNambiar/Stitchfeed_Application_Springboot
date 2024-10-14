package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
	@GetMapping
	public String homeControllerHandler() {
		return "this is home controller handler";
	}
	@GetMapping("/home")
	public String homeControllerHandler2() {
		return "this is home controller handlerX";
	}
	
	@GetMapping("/genie")
	public String homeControllerHandlerX() {
		return "HELLO GENI";
	}
	//@Putmappiing
	//@PostMapping
	//@DeleteMapping
}
