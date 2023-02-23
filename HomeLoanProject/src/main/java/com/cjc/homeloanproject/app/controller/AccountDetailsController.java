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

import com.cjc.homeloanproject.app.model.AccountDetails;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.PropertyInfo;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AccountDetailsController {
	
	@Autowired
	HomeLoanServiceI hl;
	
	@GetMapping("/getAccountDetails")
	public ResponseEntity<List<AccountDetails>> getAccountDetails()
	{
		List<AccountDetails> list=hl.getAccountDetails();
		if(list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AccountDetails>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping("/postAccountDetails")
	public ResponseEntity<AccountDetails> PostAccountDetails(@RequestBody AccountDetails ad)
	{
		if(ad.getAccountId()==0)
		{
			return new ResponseEntity<AccountDetails>(HttpStatus.BAD_REQUEST);
		}
		Customer c=hl.findCustomer(ad.getCustomerId());
		AccountDetails document=c.getAd();
		document.setAccountId(ad.getAccountId());
		document.setAccountNo(ad.getAccountNo());
		document.setAccountHolderName(ad.getAccountHolderName());
		document.setAccountType(ad.getAccountType());
		document.setAccountBalance(ad.getAccountBalance());
		
		
		
		
		AccountDetails ads=hl.PostAccountDetails(ad);
		return new ResponseEntity<AccountDetails>(ads,HttpStatus.CREATED);
	}
	@PutMapping("/updateAccountDetails/{accountId}")
	public ResponseEntity<AccountDetails> updateaccounDetails(@RequestBody AccountDetails p, @PathVariable int accountId) {
		
		AccountDetails ads = hl.updateAccountDetails(accountId,p);
		return new ResponseEntity<AccountDetails>(ads,HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccountDetails/{accountId}")
	public ResponseEntity<AccountDetails> deleteprod(@PathVariable int accountId )
	{
			
		
		hl.deleteAccountDetails(accountId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	


	
	
	
	
	
	

}
