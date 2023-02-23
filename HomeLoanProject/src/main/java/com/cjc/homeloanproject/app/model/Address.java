package com.cjc.homeloanproject.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private String fullAddress;
	private String taluka;
	private String district;
	private String state;
	private Integer pincode;
	

}
