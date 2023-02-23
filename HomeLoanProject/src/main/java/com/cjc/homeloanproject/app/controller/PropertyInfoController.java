package com.cjc.homeloanproject.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.AllPersonDocument;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.Guarantor;
import com.cjc.homeloanproject.app.model.PropertyInfo;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PropertyInfoController{
	
	@Autowired
	HomeLoanServiceI hsi;

	//get api
	@GetMapping("/getProperty")

	public ResponseEntity<List<PropertyInfo>> getPropertyInfo()

	{
		List<PropertyInfo>list=hsi.getPropertyInfo();
		 return new ResponseEntity<List<PropertyInfo>>(list,HttpStatus.OK);
		
	}
	//post Api
		@PostMapping(value ="/postProperty" )
		public ResponseEntity<PropertyInfo> savePropertyinfi(@RequestBody PropertyInfo p) {
			
			if(p.getCustomerId()==0)
			{
				return new ResponseEntity<PropertyInfo>(HttpStatus.BAD_REQUEST);
			}
			
			
		
			PropertyInfo prop=hsi.savePropertyinfi(p);
			return new ResponseEntity<PropertyInfo>(prop,HttpStatus.CREATED);
		}
		
		//delete
		@DeleteMapping(value ="/deleteProperty/{propertyId}" )
		public ResponseEntity deleteProperty(@PathVariable Integer propertyId) {
			
			
			           hsi.deleteProperty(propertyId);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//update
		@PutMapping(value ="updateproperty/{propertyId}")
		public ResponseEntity<PropertyInfo>updateProperty(@PathVariable Integer propertyId,@RequestBody PropertyInfo p) {
			PropertyInfo pro = hsi.updateProperty(propertyId,p);
			         
			return new ResponseEntity<PropertyInfo>(pro,HttpStatus.OK);
		}
	///////////Uploding Document//////
		

		
	@PostMapping(value = "/documentProperty",consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
	public List<PropertyInfo> saveDocument
	(@RequestPart("propertyDocuments")MultipartFile file,
	@RequestPart("priceProof")MultipartFile file1,
	@RequestPart ("customerId") String customerId) throws IOException{
		
		ObjectMapper om=new ObjectMapper();
		PropertyInfo d=om.readValue(customerId,PropertyInfo.class);
		
		Customer c=hsi.findCustomer(d.getCustomerId());
		PropertyInfo document=c.getPropInfo();
		
		//PropertyInfo document=new PropertyInfo();
		document.setPriceProof(file.getBytes());
		document.setPropertyDocuments(file1.getBytes());
		
		List<PropertyInfo>list=hsi.saveDocument(document);
				return list;
	}
}










