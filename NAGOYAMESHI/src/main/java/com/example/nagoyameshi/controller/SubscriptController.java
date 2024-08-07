package com.example.nagoyameshi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyameshi.entity.Users;
import com.example.nagoyameshi.security.UserDetailsImpl;
import com.example.nagoyameshi.service.StripeService;
import com.example.nagoyameshi.service.UserService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/subscript")
public class SubscriptController {

	private final StripeService stripeService;
	private final UserService userService;

	
	public SubscriptController(StripeService stripeService,UserService userService)
	{
		this.stripeService=stripeService;
		this.userService=userService;
		
	}
	
	
	
	@GetMapping("/create")
	public String create(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,HttpServletRequest httpServletRequest)
	{
		Users user=userDetailsImpl.getUser();
		
		Session session=stripeService.createStripeSession(user, httpServletRequest);
		
		
		
		return "redirect:"+session.getUrl();
	}
	
	
	@GetMapping("/cancel")
	public String cancel(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,RedirectAttributes redirectAttributes)
	{
		Users user=userDetailsImpl.getUser();
		
		try{
			System.out.println("サブスクキャンセル処理");
			
			stripeService.cancelSubscription(user);
			redirectAttributes.addFlashAttribute("successMessage","有料会員解約を完了しました");
		}
		catch(StripeException e)
		{
			System.out.println("サブスクキャンセル処理が正常に行われませんでした。");
		}
		
		userService.userDetailsUpdate(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,HttpServletRequest httpServletRequest)
	{
		Users user=userDetailsImpl.getUser();
		Session session=stripeService.updateStripeSession(user, httpServletRequest);
		
		return "redirect:"+session.getUrl();
	}
	
	@GetMapping("/register")
	public String register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,RedirectAttributes redirectAttributes)
	{
		System.out.println("register");
		Users user=userDetailsImpl.getUser();
		userService.userDetailsUpdate(user);
		redirectAttributes.addFlashAttribute("successMessage","有料会員登録が完了しました");
		
		return "redirect:/";
	}
	@GetMapping("updateConfirm")
	public String updateConfirm(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,RedirectAttributes redirectAttributes)
	{
		System.out.println("register");
		Users user=userDetailsImpl.getUser();
		userService.userDetailsUpdate(user);
		redirectAttributes.addFlashAttribute("successMessage","クレジット情報を編集しました");
		
		return "redirect:/";
	}
	
}