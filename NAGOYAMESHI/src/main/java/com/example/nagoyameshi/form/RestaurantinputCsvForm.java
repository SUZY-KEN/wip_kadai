package com.example.nagoyameshi.form;

import com.example.nagoyameshi.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantinputCsvForm
{

	
	
	private String name;
	
	
//	private MultipartFile imageFile;
	
	
	private Integer price;
	
	private Category category;
	
	private Integer capacity;
	

	
	private String description;
	
	
	private String address;
	
	
}
