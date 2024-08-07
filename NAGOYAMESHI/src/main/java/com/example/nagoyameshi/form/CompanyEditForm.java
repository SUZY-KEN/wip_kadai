package com.example.nagoyameshi.form;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyEditForm {

	
	@NotBlank(message="会社名を入力してください")
	private String name;
	
	
	private String postalFirstcode;
	
	
	private String postalLastcode;
	
	@NotBlank(message="所在地を入力してください")
	private String address;
	
	@NotBlank(message="代表者名を入力してください")
	private String president;
	
	@NotNull(message="設立日を入力してください")
	private LocalDate establishedAt;
	

	
	@NotNull(message="資本金を入力してください")
	@Min(value=1,message = "適切な金額を入力してください")
	private Integer capital;
	
	@NotBlank(message="事業内容名を入力してください")
	@Length(max = 200,message = "200字以内で記入してください")
	private String contents;
	
	@NotNull(message="従業員数を入力してください")
	@Min(value=1,message = "適切な従業員数を入力してください")
	private Integer employees;
}
