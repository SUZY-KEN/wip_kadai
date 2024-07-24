package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	
	public Users findByEmail(String email);
}
