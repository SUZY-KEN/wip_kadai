package com.example.nagoyameshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyameshi.form.SignupForm;

@Controller
public class AuthController {
	 @GetMapping("/login")
	 public String login()
	 {
		 
		 return "auth/login";
	 }
	 
	 
	 @GetMapping("/login/signup")
	 public String signup(Model model)
	 {
		 model.addAttribute("signupForm",new SignupForm());
		 
		 return "auth/signup";
	 }
}
