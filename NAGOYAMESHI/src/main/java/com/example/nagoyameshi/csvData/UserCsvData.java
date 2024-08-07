package com.example.nagoyameshi.csvData;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"氏名","email","権限","更新日"})
public class UserCsvData {

	@JsonProperty("氏名")
	String name;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("権限")
	String role;
	
	@JsonProperty("更新日")
	 @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	Timestamp createdAt;
	
	public UserCsvData(String name,String email,String role,Timestamp createdAt)
	{
		this.name=name;
		this.email=email;
		this.role=role;
		this.createdAt=createdAt;
	}
}