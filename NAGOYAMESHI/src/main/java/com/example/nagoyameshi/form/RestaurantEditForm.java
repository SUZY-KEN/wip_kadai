package com.example.nagoyameshi.form;





import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantEditForm 
{
	@NotNull
	private Integer id;
	
	@NotBlank(message="店舗名を記入してください")
	private String name;
	
	
	private MultipartFile imageFile;
	
	@NotNull(message="価格を記入してください")
	@Min(value = 1, message = "価格は1円以上に設定してください")
	private Integer price;
	
	private Integer categoryId;
	
	@NotNull(message="定員数を設定してください")
	@Min(value = 1, message = "価格は1円以上に設定してください")
	private Integer capacity;
	
//	private String salesDate;
	
	private String description;
	
	@NotBlank(message="住所を記入してください")
	private String address;
	
	
}
