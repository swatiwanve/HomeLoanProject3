package com.cjc.homeloanproject.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.homeloanproject.app.model.AllPersonDocument;

@Repository
public interface AllPersonDocumentRepository extends JpaRepository<AllPersonDocument, Integer> {

}
