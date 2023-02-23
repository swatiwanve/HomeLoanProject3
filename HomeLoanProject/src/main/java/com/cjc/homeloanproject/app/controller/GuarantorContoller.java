package com.cjc.homeloanproject.app.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.homeloanproject.app.exception.CustomerNotFoundException;
import com.cjc.homeloanproject.app.exception.GuarantorNotFoundException;
import com.cjc.homeloanproject.app.model.AllPersonDocument;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.Guarantor;
import com.cjc.homeloanproject.app.repository.GurantorRepository;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GuarantorContoller {
	
	@Autowired
	HomeLoanServiceI hsi;
	
	// getApi
	@GetMapping(value = "/getGurantor")
	public ResponseEntity<List<Guarantor>> getGuranter()
	{
		
		List<Guarantor> list=hsi.getGuranter();
	 return new ResponseEntity<List<Guarantor>>(list,HttpStatus.OK);
	}
	
		// post Api
	@PostMapping(value ="guranter" )
	public ResponseEntity<Guarantor> saveGauranter(@RequestBody Guarantor p) {
		
		Guarantor guranter=hsi.saveGauranter(p);
		return new ResponseEntity<Guarantor>(guranter,HttpStatus.CREATED);
	}
	
	@DeleteMapping(value ="guaranter/{guranterId}" )
	public ResponseEntity deleteGuranter(@PathVariable Integer guranterId) {
		
		
		           hsi.deleteGuranter(guranterId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
	@PutMapping(value ="updateGuaranter/{guranterId}" )
	public ResponseEntity<Guarantor>deleteGuranter(@PathVariable Integer guranterId,@RequestBody Guarantor p) {
		Guarantor guranter = hsi.updateGuarantor(guranterId,p);
		         
		return new ResponseEntity<Guarantor>(guranter,HttpStatus.OK);
	}
	
	///////////Uploding Document//////
	

	
	@PostMapping(value = "/document",consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<Guarantor>saveDocument(@RequestPart("photo")MultipartFile file,
			@RequestPart("pancard")MultipartFile file1,
			@RequestPart("adharcard")MultipartFile file2,
			@RequestPart("sign")MultipartFile file3,
			@RequestPart("incomeproof")MultipartFile file4,
			@RequestPart ("customerId") String customerId) throws IOException{
		
			ObjectMapper om=new ObjectMapper();
			Guarantor d=om.readValue(customerId,Guarantor .class);
	////Find by customer
			Customer c=hsi.findCustomer(d.getCustomerId());
			
			
			Guarantor document=c.getGuar();
			System.out.println(d.getGuarantorFname());
	
	document.setPhoto(file.getBytes());
	document.setPancard(file1.getBytes());
	document.setAdharcard(file2.getBytes());
	document.setSign(file3.getBytes());
	document.setIncomeproof(file4.getBytes());
	document.setCustomerId(d.getCustomerId());
	document.setGuarantorFname(d.getGuarantorFname());
	List<Guarantor>list=hsi.saveAllDocument(document);
	
	return list;
	
	}
	
	/////////////Exception Handling////////////////////////
	
	@GetMapping(value="/searchGuarantor/{guarantorFname}")
	public ResponseEntity<Guarantor> searchGuarantor(@PathVariable String guarantorFname)
	{
		Guarantor g=hsi.searchGuarantor(guarantorFname);
		//System.out.println(c.getCustomerFname());
		if(g!=null)
		{
			return new ResponseEntity<Guarantor>(g,HttpStatus.OK);
			
		}
		else
		{
			throw new GuarantorNotFoundException("Guarantor Not Found ");
		}
	}
	
	@ExceptionHandler(GuarantorNotFoundException.class)
	public ResponseEntity<String> GuarantorNotFoundException(GuarantorNotFoundException c)
	{
		return new ResponseEntity<String>(c.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	

	

}
