package com.example.nagoyameshi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.repository.CategoryRepository;
import com.example.nagoyameshi.repository.RestaurantRepository;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	private final  RestaurantRepository restaurantRepository;
	private final CategoryRepository categoryRepository;
	
	public RestaurantController(RestaurantRepository restaurantRepository,CategoryRepository categoryRepository)
	{
		this.restaurantRepository=restaurantRepository;
		this.categoryRepository=categoryRepository;
	}
	
	
	@GetMapping
	public String index(@RequestParam(name="nameKeyword",required=false)String nameKeyword,
			@RequestParam(name="category",required=false)Integer category,@RequestParam(name="price",required=false)Integer price,
			@PageableDefault(page=0,size=12,sort="id",direction = Direction.ASC)Pageable pageable,Model model) 
	{
		System.out.println("RestaurantController.indexメソッド");

		
		Page<Restaurants>restaurantsPage;
		

		

		
//		if(category!=null)
//		{
//			if(nameKeyword!=null&&!nameKeyword.isEmpty() )
//			{
//				switch(price)
//				{
//					case 1:restaurantsPage=restaurantRepository.findByCategoryAndNameLikeOrderByPriceAsc(categoryRepository.getReferenceById(category), "%"+nameKeyword+"%", pageable);
//							break;
//					case 2:restaurantsPage=restaurantRepository.findByCategoryAndNameLikeOrderByPriceDesc(categoryRepository.getReferenceById(category), "%"+nameKeyword+"%", pageable);
//							break;
//					default:restaurantsPage=restaurantRepository.findByCategoryAndNameLike(categoryRepository.getReferenceById(category), "%"+nameKeyword+"%", pageable);
//							break;
//				
//				}
//				
//			}
//			else
//			{
//				
//				switch(price)
//				{
//					case 1:restaurantsPage=restaurantRepository.findByCategoryOrderByPriceAsc(categoryRepository.getReferenceById(category), pageable);
//							break;
//					case 2:restaurantsPage=restaurantRepository.findByCategoryOrderByPriceDesc(categoryRepository.getReferenceById(category), pageable);
//							break;
//					default:restaurantsPage=restaurantRepository.findByCategory(categoryRepository.getReferenceById(category), pageable);
//							break;
//				
//				}
//				
//				
//			}
//		}
//		else 
//		{
//			if(nameKeyword!=null&&!nameKeyword.isEmpty() )
//			{
//				
//				switch(price)
//				{
//					case 1:restaurantsPage=restaurantRepository.findByNameLikeOrderByPriceAsc("%"+nameKeyword+"%", pageable);
//							break;
//					case 2:restaurantsPage=restaurantRepository.findByNameLikeOrderByPriceDesc("%"+nameKeyword+"%", pageable);
//							break;
//					default:restaurantsPage=restaurantRepository.findByNameLike("%"+nameKeyword+"%", pageable);
//							break;				
//				}
//				
//			}	
//			else
//			{
//				switch(price)
//				{
//					case 1:restaurantsPage=restaurantRepository.findAllByOrderByPriceAsc(pageable);
//							break;
//					case 2:restaurantsPage=restaurantRepository.findAllByOrderByPriceDesc(pageable);
//						   	break;
//					
//					default:restaurantsPage=restaurantRepository.findAll(pageable);
//							break;
//				
//				}
//			}
//		}
		
		if(category!=null)
		{
			if(nameKeyword!=null&&!nameKeyword.isEmpty() )
			{
				if(price!=null)
				{
					switch(price)
					{
						case 1:restaurantsPage=restaurantRepository.findByCategoryAndNameLikeOrderByPriceAsc(categoryRepository.getReferenceById(category), "%"+nameKeyword+"%", pageable);
								break;
						default:restaurantsPage=restaurantRepository.findByCategoryAndNameLikeOrderByPriceDesc(categoryRepository.getReferenceById(category), "%"+nameKeyword+"%", pageable);
								break;
						
					}
				}
				else
				{
					restaurantsPage=restaurantRepository.findByCategoryAndNameLike(categoryRepository.getReferenceById(category), "%"+nameKeyword+"%", pageable);
				}
				
			}
			else
			{
				if(price!=null)
				{
					switch(price)
					{
						case 1:restaurantsPage=restaurantRepository.findByCategoryOrderByPriceAsc(categoryRepository.getReferenceById(category), pageable);
								break;
						default:restaurantsPage=restaurantRepository.findByCategoryOrderByPriceDesc(categoryRepository.getReferenceById(category), pageable);
								break;
						
					}
				}
				else
				{
					restaurantsPage=restaurantRepository.findByCategory(categoryRepository.getReferenceById(category), pageable);
				}
				
			}
		}
		else 
		{
			if(nameKeyword!=null&&!nameKeyword.isEmpty() )
			{
				if(price!=null)
				{	
					switch(price)
					{
						case 1:restaurantsPage=restaurantRepository.findByNameLikeOrderByPriceAsc("%"+nameKeyword+"%", pageable);
								break;
						default:restaurantsPage=restaurantRepository.findByNameLikeOrderByPriceDesc("%"+nameKeyword+"%", pageable);
								break;
								
					}
				}
				else
				{
					restaurantsPage=restaurantRepository.findByNameLike("%"+nameKeyword+"%", pageable);
				}
				
			}	
			else
			{
				if(price!=null)
				{
					switch(price)
					{
						case 1:restaurantsPage=restaurantRepository.findAllByOrderByPriceAsc(pageable);
								break;
						default:restaurantsPage=restaurantRepository.findAllByOrderByPriceDesc(pageable);
							   	break;
						
						
					}
				}
				else
				{
					restaurantsPage=restaurantRepository.findAll(pageable);
				}
			}
		}	
		
		System.out.println("restaurantsPage:"+restaurantsPage);
		
		model.addAttribute("restaurantsPage",restaurantsPage);
		model.addAttribute("nameKeyword",nameKeyword);
		model.addAttribute("category",category);
		model.addAttribute("price",price);
		
		return "/restaurants/index";
	}
	
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable(name="id")Integer id,Model model) {
		
		//店舗情報を渡す
		
		Restaurants restaurant=restaurantRepository.getReferenceById(id);
		model.addAttribute("restaurants",restaurant);
		
		//レビュー情報を渡す
		
		
		return "restaurants/show";
	}
	
}