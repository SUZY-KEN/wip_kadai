package com.example.samuraitravel.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.repository.UserRepository;

@Service
public class UserDetailsServiceImp1 implements UserDetailsService {
	 private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImp1.class);
    private final UserRepository userRepository;    
    
    public UserDetailsServiceImp1(UserRepository userRepository) {
        this.userRepository = userRepository;  
        System.out.println("service 通った");
    }
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {  
        try {
            User user = userRepository.findByEmail(email);
            String userRoleName = user.getRole().getName();
            Collection<GrantedAuthority> authorities = new ArrayList<>();         
            authorities.add(new SimpleGrantedAuthority(userRoleName));
            
            System.out.println("User: " + user);
            System.out.println("User Role Name: " + userRoleName);
            System.out.println("Authorities: " + authorities);
            
            return new UserDetailsImp1(user, authorities);
        } catch (Exception e) {
        	 logger.error("User not found for email: {}", email, e);
        	
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
            
        }
    } 
    
}


//public class UserDetailsServiceImp1 implements UserDetailsService {
//
//	private final UserRepository userRepository;
//	
//	public UserDetailsServiceImp1(UserRepository userRepository)
//	{
//		this.userRepository=userRepository;
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String email) 
//	throws UsernameNotFoundException{
//		try {
//			
//			//userエンティティオブジェクトにリポジトリインターフェースのメソッドを使って、引数emailの値と一致するレコードのすべてのフィールドを格納
//			User user=userRepository.findByEmail(email);
//			//上記の各フィールドのRoleをゲットし、Roleエンティティにはいり、nameのフィールドを取ってくる。
//			String userRoleName=user.getRole().getName();
//			
//			Collection<GrantedAuthority>authorities=new ArrayList<>();
//			
//			authorities.add(new SimpleGrantedAuthority(userRoleName));
//			//UserDetailsImp1に上記で取得したフィールドを入れてインスタンス化することで認証に入る。
//			return new UserDetailsImp1(user, authorities);
//		}catch(Exception e)
//		{
//			throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
//		}
//	}
//}
