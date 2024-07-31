package com.example.nagoyameshi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.form.RestaurantEditForm;
import com.example.nagoyameshi.form.RestaurantForm;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.service.RestaurantService;

@Controller
@RequestMapping("admin/restaurant")
public class AdminRestaurantController {
	
	private final RestaurantService restaurantService;
	private final CategoryRepository categoryRepository;
	private final RestaurantRepository restaurantRepository;
	
	public AdminRestaurantController(RestaurantService restaurantService,CategoryRepository categoryRepository,RestaurantRepository restaurantRepository)
	{
		this.restaurantService=restaurantService;
		this.categoryRepository=categoryRepository;
		this.restaurantRepository=restaurantRepository;
	}

	@GetMapping("/create")
	public String show(Model model)
	{
		
		model.addAttribute("categoryList",categoryRepository.findAll());
		model.addAttribute("restaurantCreateForm",new RestaurantForm());
		return "restaurants/admin/create";
	}
	
	
	//店舗登録
	@PostMapping("/register")
	public String register(@ModelAttribute @Validated RestaurantForm restaurantForm,
			BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model)
	{
		if(restaurantService.hasSameRestaurantName(restaurantForm))
		{
			FieldError fieldError=new FieldError(bindingResult.getObjectName(),"name", "すでに店舗が存在しています");
			bindingResult.addError(fieldError);
		}
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("categoryList",categoryRepository.findAll());
			return "restaurants/admin/create";
		}
		redirectAttributes.addFlashAttribute("successMessage",restaurantForm.getName()+"の店舗情報を登録しました");
		
		restaurantService.register(restaurantForm);
		return "redirect:/restaurants?nameKeyword=&category=";
	}
	

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable (name="id")Integer id,Model model)
	{
		Restaurants restaurant=restaurantRepository.getReferenceById(id);
		
		Integer categoryId=null;
		if(restaurant.getCategory()!=null)
		{
			categoryId=restaurant.getCategory().getId();
		}
		
		String description=null;
		if(restaurant.getDescription()!=null)
		{
			description=restaurant.getDescription();
		}
		
		RestaurantEditForm restaurantEditForm=new RestaurantEditForm(restaurant.getId(), restaurant.getName(), null,restaurant.getPrice(),
				categoryId, restaurant.getCapacity(), description, restaurant.getAddress());
		
		model.addAttribute("restaurant",restaurant);
		model.addAttribute("restaurantEditForm",restaurantEditForm);
		model.addAttribute("categoryList",categoryRepository.findAll());
		System.out.println("edit:success");
		
		return "/restaurants/admin/edit";
		
	}
	
//	店舗編集
	@PostMapping("/update")
	public String update(@ModelAttribute @Validated RestaurantEditForm restaurantEditForm,
			BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model)
	{
		if(restaurantService.hasSameRestaurantEditName(restaurantEditForm))
		{
			FieldError fieldError=new FieldError(bindingResult.getObjectName(),"name", "すでに店舗が存在しています");
			bindingResult.addError(fieldError);
		}
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("restaurant",restaurantRepository.getReferenceById(restaurantEditForm.getId()));
			model.addAttribute("categoryList",categoryRepository.findAll());
			return "restaurants/admin/edit";
		}
		redirectAttributes.addFlashAttribute("successMessage",restaurantEditForm.getName()+"の店舗情報を更新しました");
		
		restaurantService.update(restaurantEditForm);
		return "redirect:/restaurants?nameKeyword=&category=";
	}
	
//店舗削除
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable(name="id")Integer id,RedirectAttributes redirectAttributes)
	{
		Restaurants restaurant=restaurantRepository.getReferenceById(id);
		
		
		redirectAttributes.addFlashAttribute("successMessage",restaurant.getName()+"の店舗情報を削除しました");
		restaurantService.delete(restaurant);
		
		
		return "redirect:/restaurants?nameKeyword=&category=";
	}
}