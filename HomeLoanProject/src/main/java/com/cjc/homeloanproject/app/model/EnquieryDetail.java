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
public class EnquieryDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private Integer enqiueryId;
	private String firstName;
	private String lastName;
	private Double mobileNo;
	private String status;
	
		

}
