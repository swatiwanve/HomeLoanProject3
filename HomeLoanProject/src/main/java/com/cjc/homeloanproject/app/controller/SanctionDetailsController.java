package com.cjc.homeloanproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.cjc.homeloanproject.app.model.SanctionDetails;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SanctionDetailsController {
	
	@Autowired
	HomeLoanServiceI hs;
	
	@PostMapping("/postSanctionDetails")
	public ResponseEntity<SanctionDetails> postSanctionDetails(@RequestBody SanctionDetails sd)
	{
		if(sd.getSanctionId()==0)
		{
			return new ResponseEntity<SanctionDetails>(HttpStatus.BAD_REQUEST);
		}
		
		SanctionDetails sanction=hs.PostSanction(sd);
		return new ResponseEntity<SanctionDetails>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getSanctionDetails")
	public ResponseEntity<List<SanctionDetails>> getSanctionDetails()
	{
		List<SanctionDetails> list=hs.getSanctionDetails();
		if(list.isEmpty())
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SanctionDetails>>(HttpStatus.OK);
	}
	@PutMapping("/updateSanctionDetails/{sanctionId}")
	public ResponseEntity<SanctionDetails> updateData(@RequestBody SanctionDetails sd, @PathVariable int sanctionId) {
		
		SanctionDetails sds = hs.updateSanctionDetail(sanctionId,sd);
		return new ResponseEntity<SanctionDetails>(sd,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSanctionDetails/{sanctionId}")
	public ResponseEntity<Address> deleteSanctionDetails(@PathVariable int sanctionId )
	{
			
		
		hs.deleteSanctionDetails(sanctionId);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//////////////email//////////
	@Value("${spring.mail.username}")
	String fromEmail;
	
	@RequestMapping("/send")
	public String sendEmail(@RequestBody SanctionDetails e)
	{
		try
		{
			e.setFromEmail(fromEmail);
			hs.sendEmail(e);
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return "sent sucessfully";
	}
	@RequestMapping(value="/emailWithAttachment",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String sendEmailWithAttachment(@RequestPart(required=true,value="attachment") MultipartFile at,
			@RequestPart("email") String e)
	{
		try
		{
			ObjectMapper o=new ObjectMapper();
			
			SanctionDetails es =o.readValue(e, SanctionDetails.class);
			SanctionDetails em=new SanctionDetails();
			
			em.setFromEmail(fromEmail);
			System.out.println(em.getFromEmail());
			em.setToEmail(es.getToEmail());
			em.setTextBody(es.getTextBody());
			em.setSubject(es.getSubject());
			
			hs.sendEmailWithAttachment(em,at);
			
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return null;
		
	
	}
}
