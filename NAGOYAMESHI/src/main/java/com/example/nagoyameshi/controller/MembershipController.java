package com.example.nagoyameshi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyameshi.security.UserDetailsImpl;

@Controller
@RequestMapping("/membership")
public class MembershipController {

	@GetMapping("/create")
	public String register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,Model model)
	{
		
		return "membership/create";
	}
}