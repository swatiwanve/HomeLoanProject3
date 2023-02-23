package com.cjc.homeloanproject.app.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.cjc.homeloanproject.app.exception.AddressNotFoundException;
import com.cjc.homeloanproject.app.exception.EnquieryDetailsNotFoundException;
import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.EnquieryDetail;
import com.cjc.homeloanproject.app.model.SanctionDetails;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class EnquieryDetailsController {
	
	@Autowired
	HomeLoanServiceI hi;
	
	@PostMapping("/postEnquieryDetail")
	public ResponseEntity<EnquieryDetail> postEnquieryDetail(@RequestBody EnquieryDetail ed)
	{
		if(ed.getCustomerId()==0)
		{
			return new ResponseEntity<EnquieryDetail>(HttpStatus.BAD_REQUEST);
		}
		
		EnquieryDetail sanction=hi.PostEnquiery(ed);
		return new ResponseEntity<EnquieryDetail>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getEnquieryDetail")
	public ResponseEntity<List<EnquieryDetail>> getEnquieryDetail()
	{
		List<EnquieryDetail> list=hi.getEnquiery();
		if(list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EnquieryDetail>>(HttpStatus.OK);
	}
	@PutMapping("/updateEnquieryDetail/{enqiueryId}")
	public ResponseEntity<EnquieryDetail> updateData(@RequestBody EnquieryDetail ed, @PathVariable int enqiueryId) {
		
		EnquieryDetail eds = hi.updateEnquiery(enqiueryId,ed);
		return new ResponseEntity<EnquieryDetail>(eds,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEnquieryDetail/{enqiueryId}")
	public ResponseEntity<EnquieryDetail> deleteSanctionDetails(@PathVariable int enqiueryId )
	{
			
		
		hi.deleteEnquiery(enqiueryId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
////////////////Exception Handling//////////////
	
@GetMapping(value="/searchEnquieryDetails/{firstName}")
public ResponseEntity<EnquieryDetail> searchEnquieryDetail(@PathVariable String firstName)
{
	EnquieryDetail c=hi.searchEnquieryDetail(firstName);

	if(c!=null)
	{
			return new ResponseEntity<EnquieryDetail>(c,HttpStatus.OK);

	}
	else
	{
		throw new EnquieryDetailsNotFoundException("EnquieryDetail Not Found Exception");
	}
}
	@ExceptionHandler(EnquieryDetailsNotFoundException.class)
	public ResponseEntity<String> EnquieryDetail(EnquieryDetailsNotFoundException c)
	{
		return new ResponseEntity<String>(c.getMessage(),HttpStatus.NOT_FOUND);
	}
}
