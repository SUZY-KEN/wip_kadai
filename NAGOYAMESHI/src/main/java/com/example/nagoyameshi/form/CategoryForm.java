package com.example.nagoyameshi.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryForm {

	@NotBlank(message="カテゴリ名を記入してください")
	private String name;
}
