package com.cjc.homeloanproject.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class PropertyInfo 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private String propertyType;
	private Double propertyPrice;
	@Lob
	private byte[] propertyDocuments;
	@Lob
	private byte[] priceProof;
	
	

}
