package com.cjc.homeloanproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloanproject.app.model.PropertyInfo;

@Repository
public interface PropertyInfoRepository  extends JpaRepository<PropertyInfo, Integer>{

}
