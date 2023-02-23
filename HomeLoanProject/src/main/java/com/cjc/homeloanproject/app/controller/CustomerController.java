package com.cjc.homeloanproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloanproject.app.exception.CustomerNotFoundException;
import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;




@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CustomerController
{
	@Autowired
	HomeLoanServiceI hlsi;
	
	@GetMapping("/getData")
	public ResponseEntity<List<Customer>> getCustomer()
	{

		List<Customer> list=hlsi.getCustomer();
		if(list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping("/postData")
	public ResponseEntity<Customer> PostCustomer(@RequestBody Customer c)
	{
		if(c.getCustomerId()==0)
		{
			
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			
		}
		
		Customer cust=hlsi.PostCustomer(c);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	@PutMapping("/updateData/{id}")
	public ResponseEntity<Customer> updateData(@RequestBody Customer p, @PathVariable int id) {
		
		Customer cust = hlsi.updateCustomer(id,p);
		return new ResponseEntity<Customer>(p,HttpStatus.OK);
		
	}

	@DeleteMapping("/deleteData/{customerId}")
	
	public ResponseEntity<Customer> deleteprod(@PathVariable int customerId )
	{
			
		
		hlsi.delete(customerId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/searchCustomer/{customerFname}")
	public ResponseEntity<Customer> searchCustomer(@PathVariable String customerFname)
	{
		Customer c=hlsi.searchCustomer(customerFname);
		//System.out.println(c.getCustomerFname());
		if(c!=null)
		{
			return new ResponseEntity<Customer>(c,HttpStatus.OK);
			
		}
		else
		{
			throw new CustomerNotFoundException("Customer Not Found ");
		}
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> CustomerNotFoundException(CustomerNotFoundException c)
	{
		return new ResponseEntity<String>(c.getMessage(),HttpStatus.NOT_FOUND);
	}
	

}
