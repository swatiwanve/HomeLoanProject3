package com.cjc.homeloanproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.homeloanproject.app.model.AllPersonDocument;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.Guarantor;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AllPersonDocumentController {
	
	@Autowired
	HomeLoanServiceI hli;
	
	
	
	@PostMapping(value="/allDocument",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<AllPersonDocument> saveDocument(@RequestPart(value="photo",required = true) MultipartFile file,
			@RequestPart(value="pancard",required = true) MultipartFile file1,
			@RequestPart(value="adharcard",required=true) MultipartFile file2,
			@RequestPart(value="sign",required=true) MultipartFile file3,
			@RequestPart(value="incomeproof",required=true) MultipartFile file4,
			@RequestPart(value="customerId",required=true) String cusId) throws Exception 
	{
		
		//Convert to java
		ObjectMapper om=new ObjectMapper();
		AllPersonDocument d=om.readValue(cusId,AllPersonDocument.class);
		String json=om.writeValueAsString(d);
		//System.out.println(json);
		//System.out.println(d.getCusId());
		
		Customer c=hli.findCustomer(d.getCustomerId());
		
		AllPersonDocument doc= c.getApd();
		doc.setCustomerId(d.getCustomerId());
		doc.setPhoto(file.getBytes());
		doc.setPancard(file1.getBytes());
		doc.setAdharcard(file2.getBytes());
		doc.setSign(file3.getBytes());
		doc.setIncomeproof(file4.getBytes());
		
		
		List<AllPersonDocument> list=hli.saveDocumentCustomer(doc);
		
			return list;
	}
	

	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
			//Customer c= hlsi.findCustomer(customerId);
		
		
//		ObjectMapper om=new ObjectMapper();
//		
//		AllPersonDocument es=om.readValue(custId, AllPersonDocument.class);
//		String json=om.writeValueAsString(es);
//		Guarantor document=new Guarantor();
//		//System.out.println(d.getGuarantorFname());
//
//document.setPhoto(file1.getBytes());
//document.setPancard(file2.getBytes());
//document.setAdharcard(file3.getBytes());
//document.setSign(file4.getBytes());
//document.setIncomeproof(file5.getBytes());
//document.setCustomerId(d.getCustomerId());
////document.
//	List<Guarantor>list=hlsi.saveAllDocument(document);
//
//	return (ResponseEntity<AllPersonDocument>) list;
//		
//	}
	    
		
		
			
	
	
	    

}
