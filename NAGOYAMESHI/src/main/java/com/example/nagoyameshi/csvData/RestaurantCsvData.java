package com.example.nagoyameshi.csvData;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@JsonPropertyOrder({"店舗名","住所","説明","価格","カテゴリー","定員数","評価","更新日"})
@AllArgsConstructor
public class RestaurantCsvData {

	@JsonProperty("店舗名")
	String name;

	@JsonProperty("住所")
	 String address;
	
	@JsonProperty("説明")
	 String description;
	
	
	
	@JsonProperty("価格")
	 Integer price;
	
	@JsonProperty("カテゴリー")
	 String category;
	
//	private String salesDate;
	

	@JsonProperty("定員数")
	 Integer capacity;
	
	
	
	@JsonProperty("評価")
	 Double evaluesDouble;
	
	@JsonProperty("更新日")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	 Timestamp createdAt;
	
}

