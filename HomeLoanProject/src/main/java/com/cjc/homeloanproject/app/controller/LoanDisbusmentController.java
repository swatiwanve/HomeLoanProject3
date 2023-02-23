package com.cjc.homeloanproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.LoanDisbusment;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class LoanDisbusmentController {
	
	@Autowired
	HomeLoanServiceI hsi;
	
	@GetMapping("/getDisbusment")
	public ResponseEntity<List<LoanDisbusment>> getLoanDisbus()
	{
		List<LoanDisbusment> list=hsi.getLoanDisbusment();
		if(list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LoanDisbusment>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping("/postDisburst")
	public ResponseEntity<LoanDisbusment> saveLoanDisburst(@RequestBody LoanDisbusment agreementId)
	{
		LoanDisbusment loandisburst =hsi.saveLoanDisburst(agreementId);
		return new ResponseEntity<LoanDisbusment>(loandisburst,HttpStatus.CREATED);
	}
	
	
	@PutMapping(value ="/updatedisburst/{agreementId}")
	public ResponseEntity<LoanDisbusment> updateLoanDisburstment(@PathVariable Integer agreementId ,@RequestBody LoanDisbusment ld)
	{
		LoanDisbusment loan = hsi.updateLoanDisburstment(agreementId,ld);
        
		return new ResponseEntity<LoanDisbusment>(loan,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteDisbusment/{agreementId}")
	public ResponseEntity<Customer> deleteprod(@PathVariable int agreementId )
	{
			
		
		hsi.deleteDisbusment(agreementId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
