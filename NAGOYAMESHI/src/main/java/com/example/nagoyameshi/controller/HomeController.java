package com.example.nagoyameshi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nagoyameshi.entity.Category;
import com.example.nagoyameshi.repository.CategoryRepository;


@Controller
public class HomeController {
	
	private final CategoryRepository categoryRepository;
	
	public HomeController(CategoryRepository categoryRepository)
	{
		this.categoryRepository=categoryRepository;
	}
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		System.out.println("HomeController.indexメソッド");
		
		List<Category>categoryList=categoryRepository.findAll();
		
		
		model.addAttribute("categoryList",categoryList);
		
		
		return "index";
	}
	

}
