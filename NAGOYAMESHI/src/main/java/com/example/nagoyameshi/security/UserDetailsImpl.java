package com.example.nagoyameshi.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.nagoyameshi.entity.Users;

public class UserDetailsImpl implements UserDetails{

	private final Users user;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Users user,Collection<GrantedAuthority> authorities)
	{
		this.user=user;
		this.authorities=authorities;
	}
	
	 public Users getUser() {
		 
         return user;
     }
	 
	 @Override
	 public String getPassword()
	 {
		 System.out.println("Getting Password: " + user.getPassword());
		 return user.getPassword();
	 }
	 
	 @Override
	 public String getUsername()
	 {
	    	System.out.println("Getting Email: " + user.getEmail());

		 return user.getEmail();
	 }
	 
	 @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
    	 System.out.println("Getting Authorities: " + authorities);

         return authorities;
     }
	 
	 // アカウントが期限切れでなければtrueを返す
     @Override
     public boolean isAccountNonExpired() {
         return true;
     }
     
     // ユーザーがロックされていなければtrueを返す
     @Override
     public boolean isAccountNonLocked() {
         return true;
     }    
     
     // ユーザーのパスワードが期限切れでなければtrueを返す
     @Override
     public boolean isCredentialsNonExpired() {
         return true;
     }
     
     @Override
     public boolean isEnabled() {
         return user.getEnabled();
     }
     
     
}
