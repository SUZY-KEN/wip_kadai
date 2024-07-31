package com.example.nagoyameshi.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="reservations")
@Data
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurants restaurant;
	
	@Column(name = "checkin_date")
	private LocalDate checkinDate;
	 
	@Column(name = "checkin_time")
	private LocalTime checkinTime;   
	 
	@Column(name = "number_of_people")
	private Integer numberOfPeople; 
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
}
