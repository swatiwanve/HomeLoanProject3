package com.cjc.homeloanproject.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloanproject.app.model.EnquieryDetail;

@Repository
public interface EnquieryDetailsRepository extends JpaRepository<EnquieryDetail, Integer> {

	public EnquieryDetail findByFirstName(String firstName);

	
}
