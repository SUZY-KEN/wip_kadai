package com.example.nagoyameshi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyameshi.entity.Users;
import com.example.nagoyameshi.repository.UserRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;



@Controller
public class MypageController {
	
	private final UserRepository userRepository;
	
	public MypageController(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}

	@GetMapping("/mypage/index")
	public String index() {
		
		return "/mypage/index";
	}
	
//	会員情報
	@GetMapping("/mypage/showUser")
	public String showUser(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,Model model)
	{
		Users user=userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		
		model.addAttribute("user",user);
		return "user/show";
	}
	
//	有料会員登録
	
	
//	クレジットカード編集
	
	
//	有料会員解約
	

//予約一覧
	
//お気に入り一覧
}