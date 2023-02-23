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
@NoArgsConstructor
@Entity
public class AllPersonDocument {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	@Lob
	private byte[] adharcard;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] sign;
	@Lob
	private byte[] incomeproof;
	
	
	

}
