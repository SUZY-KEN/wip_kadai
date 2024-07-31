package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.Users;
import com.example.nagoyameshi.repository.FavoriteRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.FavoriteService;

@Controller

public class FavoriteController {
	private final RestaurantRepository restaurantRepository;
	private final FavoriteService favoriteService;
	private final FavoriteRepository favoriteRepository;
	
	public FavoriteController(RestaurantRepository restaurantRepository,FavoriteService favoriteService,FavoriteRepository favoriteRepositor)
	{
		this.restaurantRepository=restaurantRepository;
		this.favoriteService=favoriteService;
		this.favoriteRepository=favoriteRepositor;
	}
	
	
//	お気に入り一覧
	@GetMapping("/favorite")
	public String index(@PageableDefault(page=0,size=10,sort="id")Pageable pageable,@AuthenticationPrincipal 
			UserDetailsImpl userDetailsImpl,Model model)
	{
		Users user=userDetailsImpl.getUser();
		Page<Favorite> favoritePage=favoriteRepository.findByUserOrderByCreatedAtDesc(user, pageable);
		
		model.addAttribute("favoritePage",favoritePage);
		return "favorite/index";
	}
	
	
//	お気に入り登録
	@GetMapping("/favorite/{restaurantId}/register")
	public String register(@PathVariable(name="restaurantId")Integer restaurantId,@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,Model model)
	{
		Restaurants restaurants=restaurantRepository.getReferenceById(restaurantId);
		Users user=userDetailsImpl.getUser();
		favoriteService.register(user, restaurants);
		
		System.out.println("FavoriteRegister>>>");
		
		return "redirect:/restaurants/show/"+restaurantId;
		
		
		
	}
	
//	お気に入り解除
	@GetMapping("/favorite/{restaurantId}/cancel")
	public String cancel(@PathVariable(name="restaurantId")Integer restaurantId,@AuthenticationPrincipal UserDetailsImpl userDetailsImpl)
	{
		Restaurants restaurants=restaurantRepository.getReferenceById(restaurantId);
		Users user=userDetailsImpl.getUser();
		favoriteService.cancel(user, restaurants);
		
		System.out.println("FavoriteCancelar>>>");
		
		return "redirect:/restaurants/show/"+restaurantId;
	}
	
//	お気に入り解除
	@GetMapping("/favorite/index/{restaurantId}/cancel")
	public String cancelIndex(@PathVariable(name="restaurantId")Integer restaurantId,@AuthenticationPrincipal UserDetailsImpl userDetailsImpl)
	{
		Restaurants restaurants=restaurantRepository.getReferenceById(restaurantId);
		Users user=userDetailsImpl.getUser();
		favoriteService.cancel(user, restaurants);
		
		System.out.println("FavoriteCancelar>>>");
		
		return "redirect:/favorite/{restaurantId}/register";
	}
	

}