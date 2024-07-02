package com.example.samuraitravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@Controller

//public class AuthController {
//	@GetMapping("/login")
//	public String login()
//	{
//		 System.out.println("authコントローラー通った");
//	return "auth/login";
//	}}
	 @Controller
	 public class AuthController {
	      @GetMapping("/login")
	      public String login() {
	    	  
	    	  
	    	  System.out.println("authコントローラー通った");
	          return "auth/login";
	      }
	 }

	

