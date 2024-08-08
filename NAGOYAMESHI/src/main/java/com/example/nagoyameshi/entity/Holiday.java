package com.example.nagoyameshi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="holiday")
@Data
public class Holiday {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="restaurant_id")
	private Restaurants restaurantId;
	
	@Column(name="mon")
	private Boolean monday;
	@Column(name="tue")
	private Boolean tuesday;
	@Column(name="wed")
	private Boolean wednesday;
	@Column(name="thr")
	private Boolean thursday;
	@Column(name="fri")
	private Boolean friday;
	@Column(name="sat")
	private Boolean saturday;
	@Column(name="sun")
	private Boolean sunday;

}
