package com.cjc.homeloanproject.app.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private String customerFname;
	private String customerMname; 
	private String customerLname;
	private String dateofBirth;
	private Integer customerAge;
	private String customerGender;
	private String customerEmail;
	private String customerMobNo;
	private Double customerAmountPaidForHome;
	private Double loanRequired;
	private boolean previousLoan;
	private String status ;
	
	@OneToOne(cascade=CascadeType.ALL)
	private AllPersonDocument apd;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address addr;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Guarantor guar;
	
	@OneToOne(cascade=CascadeType.ALL)
	private PropertyInfo propInfo;
	

	@OneToOne(cascade=CascadeType.ALL)
	private AccountDetails ad;


	



}
		