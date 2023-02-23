package com.cjc.homeloanproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloanproject.app.model.Customer;
@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Integer>{
	
	public Customer findByCustomerFname(String  customerFname);

}
