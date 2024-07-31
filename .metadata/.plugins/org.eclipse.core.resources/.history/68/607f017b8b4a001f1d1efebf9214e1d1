package com.example.nagoyameshi.service;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.Users;
import com.example.nagoyameshi.repository.FavoriteRepository;

@Service
public class FavoriteService {
	private final FavoriteRepository favoriteRepository;
	
	public FavoriteService(FavoriteRepository favoriteRepository)
	{
		this.favoriteRepository=favoriteRepository;
	}
	
	public boolean isFavoriteRestaurant(Users user,Restaurants restaurants)
	{
		return  favoriteRepository.findByUserAndRestaurant(user, restaurants)!=null;
	}
	
	//お気に入り登録
	public void register(Users user,Restaurants restaurant)
	{
		Favorite favorite=new Favorite();
		favorite.setUser(user);
		favorite.setRestaurant(restaurant);
		favorite.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		
		favoriteRepository.save(favorite);
		
	}
	
	//お気に入り解除
	public void cancel(Users user,Restaurants restaurant)
	{
		favoriteRepository.delete(favoriteRepository.findByUserAndRestaurant(user, restaurant));
	}

}
