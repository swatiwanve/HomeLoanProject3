package com.cjc.homeloanproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloanproject.app.model.LoanDisbusment;

@Repository
public interface LoanDisbusmentRepository extends JpaRepository<LoanDisbusment, Integer> {

}
