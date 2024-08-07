package com.example.nagoyameshi.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.nagoyameshi.entity.Users;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.StripeObject;
import com.stripe.model.Subscription;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionRetrieveParams;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StripeService {

	 @Value("${stripe.api-key}")
     private String stripeApiKey;
	
	 private final UserService userService;
	
	 
	 public StripeService(UserService userService)
	 {
		 this.userService=userService;
		 
		
	 }
	 
//	 サブスクリプションセッションの開始
	public Session createStripeSession(Users user,HttpServletRequest httpServletRequest)
	{
		Stripe.apiKey=stripeApiKey;
		String requestUrl = new String(httpServletRequest.getRequestURL());
		System.out.println(requestUrl);
		
		SessionCreateParams params=new SessionCreateParams.Builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
			
				.setSuccessUrl(requestUrl.replaceAll("/subscript/create", "/subscript/register"))
				.setCancelUrl(requestUrl.replaceAll("/subscript/create", ""))
				.setMode(SessionCreateParams.Mode.SUBSCRIPTION)
				.putMetadata("userId", user.getId().toString())
				.addLineItem(SessionCreateParams.LineItem.builder()
				 	.setQuantity(1L)
				 	.setPrice("price_1PicNDCj3ORFf5wgQtp40GLh")
				 	
				 	.build())
				.build();
		
		try {
			
			
			Session session=Session.create(params);
			System.out.println(session);
      	
			return session;
		}catch (StripeException e) {
			  e.printStackTrace();
	             return null;
		}
	}
	
	//セッションから帰ってきたイベントを処理
	 public void processSessionCompleted(Event event) {
         Optional<StripeObject> optionalStripeObject = event.getDataObjectDeserializer().getObject();
         optionalStripeObject.ifPresentOrElse(stripeObject -> {
             Session session = (Session)stripeObject;
             SessionRetrieveParams params = SessionRetrieveParams.builder().addExpand("payment_intent").build();
             
 
         try {
             session = Session.retrieve(session.getId(), params, null);
            if( !session.getMetadata().isEmpty())
            {	
            	System.out.println("有料会員の登録処理");
            	 Map<String, String> metadata =session.getMetadata();
            	userService.subscription(metadata,session.getSubscription(),session.getCustomer());
            }
                 
             } catch (StripeException e) {
                 e.printStackTrace();
             }
             System.out.println("有料会員の登録処理が成功しました。");
             System.out.println("Stripe API Version: " + event.getApiVersion());
             System.out.println("stripe-java Version: " + Stripe.VERSION);
             System.out.println("sessionId: " + session.getId());
         },
         () -> {
             System.out.println("有料会員の登録処理が失敗しました。");
             System.out.println("Stripe API Version: " + event.getApiVersion());
             System.out.println("stripe-java Version: " + Stripe.VERSION);
         });
     }
	 
//	 サブスクリプション情報の削除	 
	 public void cancelSubscription(Users user)
			 throws StripeException{
	 
		 Stripe.apiKey=stripeApiKey;
		 
		 
		 Subscription subscription=Subscription.retrieve(userService.disSubscription(user));
		
			
		 subscription.cancel();
 
	 }
	 
//	 サブスクリプション更新セッションの開始
	 public Session updateStripeSession(Users user,HttpServletRequest httpServletRequest)
	 {
			Stripe.apiKey=stripeApiKey;
			String requestUrl = new String(httpServletRequest.getRequestURL());
			System.out.println(requestUrl);
			
			SessionCreateParams params =
					  SessionCreateParams.builder()
					    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
					    .setMode(SessionCreateParams.Mode.SETUP)
					    .setCustomer(userService.findstripeTokenByUser(user).getCustomerId())
					    .setSuccessUrl(requestUrl.replaceAll("/subscript/update", "/subscript/updateConfirm"))
						.setCancelUrl(requestUrl.replaceAll("/subscript/update", ""))
					    .build();
			
			
			
			try {
				
				
				Session session=Session.create(params);
				System.out.println(session);
	      	
				return session;
			}catch (StripeException e) {
				  e.printStackTrace();
		             return null;
			}
	 }
}