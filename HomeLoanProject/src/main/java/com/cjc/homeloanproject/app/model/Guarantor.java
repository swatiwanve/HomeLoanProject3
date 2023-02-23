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
public class Guarantor

{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private Integer gurantorId;
	private String guarantorFname;
	private String guarantorMname; 
	private String guarantorLname;
	private String dateofBirth;
	private Integer guarantorAge;
	private String guarantorGender;
	private String guarantorMobNo;
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
