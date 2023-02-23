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
public class SanctionDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private Integer sanctionId;
	private String sanctionDate;
	private String 	applicantName;
	private Double loanAmountSanction;
	private String interestType;
	private String rateOfInterest;
	private String loanTenure;
	private Double monthlyEMIAmt;
	
	private String fromEmail;
	private String toEmail;
	private String textBody;
	private String subject;
	
	
	
	

}
