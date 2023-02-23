package com.cjc.homeloanproject.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cjc.homeloanproject.app.model.AccountDetails;
import com.cjc.homeloanproject.app.model.Address;
import com.cjc.homeloanproject.app.model.AllPersonDocument;
import com.cjc.homeloanproject.app.model.Customer;
import com.cjc.homeloanproject.app.model.EnquieryDetail;
import com.cjc.homeloanproject.app.model.Guarantor;
import com.cjc.homeloanproject.app.model.LoanDisbusment;
import com.cjc.homeloanproject.app.model.PropertyInfo;
import com.cjc.homeloanproject.app.model.SanctionDetails;


public interface HomeLoanServiceI {

	public List<Customer> getCustomer();
	public Customer PostCustomer(Customer c);
	public Customer updateCustomer(int id, Customer p);
	public void delete(int customerId);
	
	////////////All Person Document///////////////////////
	//public List<AllPersonDocument> saveDocument(AllPersonDocument document);
	
	public List<AllPersonDocument> saveDocumentCustomer(AllPersonDocument doc);
	
	//***************Guarantor********************
	public List<Guarantor> getGuranter();
	public Guarantor saveGauranter(Guarantor p);
	public void deleteGuranter(Integer guranterId);
	public Guarantor updateGuarantor(Integer guranterId, Guarantor p);
	public List<Guarantor> saveAllDocument(Guarantor document);

	//////////Address////

	public Address PostCustomer(Address a);
	public List<Address> getAddress();
	public Address updateCustomerAddress(int customerAddrId, Address a);
	public void deleteAdress(int customerAddrId);

	
	
	

	///////Loan Disbusment//////////////
	
	public List<LoanDisbusment> getLoanDisbusment();
	public LoanDisbusment saveLoanDisburst(LoanDisbusment agreementId);
	public LoanDisbusment updateLoanDisburstment(Integer agreementId, LoanDisbusment ld);
	public void deleteDisbusment(int agreementId);
	public List<PropertyInfo> getPropertyInfo();
	public PropertyInfo savePropertyinfi(PropertyInfo p);
	public void deleteProperty(Integer propertyId);
	//public PropertyInfo updateProperty(Integer propertyId, PropertyInfo p);
	public PropertyInfo updateProperty(Integer propertyId, PropertyInfo p);
	public List<PropertyInfo> saveDocument(PropertyInfo document);
	
	//////////////Sanction Details///////////////////////////////////
	public SanctionDetails PostSanction(SanctionDetails sd);
	public List<SanctionDetails> getSanctionDetails();
	public SanctionDetails updateSanctionDetail(int sanctionId, SanctionDetails sd);
	public void deleteSanctionDetails(int sanctionId);
	public void sendEmailWithAttachment(SanctionDetails em, MultipartFile at);
	public void sendEmail(SanctionDetails e);
	
	
	////////////Enquiery Details//////////////////////
	public EnquieryDetail PostEnquiery(EnquieryDetail sd);
	public List<EnquieryDetail> getEnquiery();
	public EnquieryDetail updateEnquiery(int enqiueryId, EnquieryDetail sd);
	public void deleteEnquiery(int enqiueryId);
	
	
	////////////////////Account Details//////////////////
	public void deleteAccountDetails(int accountId);
	public AccountDetails updateAccountDetails(int accountId, AccountDetails p);
	public AccountDetails PostAccountDetails(AccountDetails ad);
	public List<AccountDetails> getAccountDetails();
	public Customer findCustomer(Integer customerId);
	
	/////////Exception Handling Method//////////////////
	public Customer searchCustomer(String  customerFname);
	public Guarantor searchGuarantor(String guarantorFname);
	public Address searchAddress(String fullAddress);
	public EnquieryDetail searchEnquieryDetail(String firstName);
	
	
	
	
	
	
	
	
	
	



	



}
