package com.example.nagoyameshi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Roles;
import com.example.nagoyameshi.entity.Users;
import com.example.nagoyameshi.form.SignupForm;
import com.example.nagoyameshi.repository.RoleRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class UserService {
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserService(RoleRepository roleRepository,UserRepository userRepository,PasswordEncoder passwordEncoder)
	{
		this.roleRepository=roleRepository;
		this.userRepository=userRepository;
		this.passwordEncoder=passwordEncoder;
	}

	
	
	//新規登録時
	@Transactional
	public Users create(SignupForm signupForm)
	{
		Users user=new Users();
		Roles role=roleRepository.findByName("ROLE_GENERAL");
		
		user.setName(signupForm.getName());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setRole(role);
		user.setEnabled(false);
		
		return userRepository.save(user);
	}
	
	//新規登録時メール整合
	public boolean isEmailRegistered(String email)
	{
		Users user=userRepository.findByEmail(email);
		 return user!=null;
	}
	
	//パスワード整合
	 public boolean isSamePassword(String password, String confirmPassword) {
         return password.equals(confirmPassword);
     } 
	
  @Transactional
     public void enableUser(Users user) 
  {
         user.setEnabled(true); 
         userRepository.save(user);
     }    
	
}