package com.cjc.homeloanproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.homeloanproject.app.model.SanctionDetails;

public interface SanctionDetailsRepository extends JpaRepository<SanctionDetails, Integer> {

}
