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
public class LoanDisbusment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private Integer agreementId;
	private Integer loanNo;	
	private String agreementDate;
	private String amountPayType;
	private Double totalAmount;
	private String bankName;	
	private Long accountNumber;
	private String IFSCCode;
	private String accountType;
	private Double transferAmount;
	private String paymentStatus;
	private String amountPaidDate;


}
