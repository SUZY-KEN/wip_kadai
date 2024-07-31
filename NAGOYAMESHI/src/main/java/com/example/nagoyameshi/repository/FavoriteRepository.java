package com.example.nagoyameshi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Favorite;
import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.entity.Users;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer>{
	
	public Favorite findByUserAndRestaurant(Users user,Restaurants restaurant);
	public Page<Favorite> findByUserOrderByCreatedAtDesc(Users user,Pageable pageable);
	
	public List<Favorite>findAllByRestaurant(Restaurants restaurants);

}