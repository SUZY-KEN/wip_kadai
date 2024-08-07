package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.StripeTokens;
import com.example.nagoyameshi.entity.Users;

public interface StripeTokensRepository extends JpaRepository<StripeTokens, Integer>{

	public StripeTokens findByUserId(Users userId);
}
