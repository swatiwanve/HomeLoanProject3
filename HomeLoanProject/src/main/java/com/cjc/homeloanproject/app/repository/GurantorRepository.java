package com.cjc.homeloanproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.homeloanproject.app.model.Guarantor;

public interface GurantorRepository extends JpaRepository<Guarantor, Integer>{

	public Guarantor findByGuarantorFname(String guarantorFname);

}
