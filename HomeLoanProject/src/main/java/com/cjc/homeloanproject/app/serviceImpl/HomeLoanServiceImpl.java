package com.cjc.homeloanproject.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
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
import com.cjc.homeloanproject.app.repository.AccountDetailsRepository;
import com.cjc.homeloanproject.app.repository.AddressRepository;
import com.cjc.homeloanproject.app.repository.AllPersonDocumentRepository;
import com.cjc.homeloanproject.app.repository.EnquieryDetailsRepository;
import com.cjc.homeloanproject.app.repository.GurantorRepository;
import com.cjc.homeloanproject.app.repository.CustomerRepository;
import com.cjc.homeloanproject.app.repository.LoanDisbusmentRepository;
import com.cjc.homeloanproject.app.repository.PropertyInfoRepository;
import com.cjc.homeloanproject.app.repository.SanctionDetailsRepository;
import com.cjc.homeloanproject.app.service.HomeLoanServiceI;
@Service
public class HomeLoanServiceImpl implements HomeLoanServiceI
{
	@Autowired
	CustomerRepository hlr;
	
	@Autowired
	AllPersonDocumentRepository apd;
	
	@Autowired
	GurantorRepository gr;
	
	@Autowired
	AddressRepository ar;
	
	@Autowired
	JavaMailSender jms;
	
	@Autowired
	AccountDetailsRepository ad;
	
	@Autowired
	LoanDisbusmentRepository ldr;
	
	@Autowired
	PropertyInfoRepository pir;
	
	@Autowired
	SanctionDetailsRepository sdr;
	
	@Autowired
	EnquieryDetailsRepository edr;

	////////////////////////////Customer////////////////////
	@Override
	public List<Customer> getCustomer()
	{
		List<Customer> list=hlr.findAll();
		
		return list;
	}

	@Override
	public Customer PostCustomer(Customer c)
	{
		Customer cust=hlr.save(c);
		return cust;
	}

	@Override
	public Customer updateCustomer(int customerId, Customer c) {
		Optional<Customer> op  = hlr.findById(customerId);
		 if(op.isPresent()) 
		 {
			 Customer cust= op.get();
			 cust.setCustomerFname(c.getCustomerFname());
			 cust.setCustomerMname(c.getCustomerMname());
			 cust.setCustomerLname(c.getCustomerLname());
			 cust.setCustomerAge(c.getCustomerAge());
			 cust.setCustomerAmountPaidForHome(c.getCustomerAmountPaidForHome());
			 cust.setCustomerEmail(c.getCustomerEmail());
			 cust.setCustomerGender(c.getCustomerGender());
			 cust.setCustomerMobNo(c.getCustomerMobNo());
			 cust.setDateofBirth(c.getDateofBirth());
			 cust.setLoanRequired(c.getLoanRequired());
			 cust.setPreviousLoan(false);
			 cust.setStatus(c.getStatus());
			 return   hlr.save(cust);
		 }
		 else
		 {
			 return null;
		 }
		
		
	}

	@Override
	public void delete(int customerId) {
		hlr.deleteById(customerId);
		
	}

///////////////////////////////Guarantor////////////////////////
		
		@Override
		public List<Guarantor> getGuranter() 
		{
			List<Guarantor> list=gr.findAll();
			return list;
		}

		@Override
		public Guarantor saveGauranter(Guarantor p) {
			
			Guarantor g=gr.save(p);
			return g;
		}

		@Override
		public void deleteGuranter(Integer guranterId) {
			gr.deleteById(guranterId);
			
		}

		@Override
		public Guarantor updateGuarantor(Integer guranterId, Guarantor c) {
			
			Optional<Guarantor> op  = gr.findById(guranterId);
			 if(op.isPresent()) 
			 {
				 Guarantor gur= op.get();
				 gur.setCustomerId(c.getCustomerId());
				 gur.setGurantorId(c.getGurantorId());
				 gur.setGuarantorFname(c.getGuarantorFname()); 
				 gur.setGuarantorMname(c.getGuarantorMname());
				 gur.setGuarantorLname(c.getGuarantorLname());
				 gur.setGuarantorAge(c.getGuarantorAge());
				 gur.setGuarantorGender(c.getGuarantorGender());
				 gur.setGuarantorMobNo(c.getGuarantorMobNo());
				 gur.setDateofBirth(c.getDateofBirth());
				 return   gr.save(gur);
			 }
			 else
			 {
				 return null;
			 }
		
		}

		

		@Override
		public List<Guarantor> saveAllDocument(Guarantor document) {
			
			gr.save(document);
			return gr.findAll();
		}

		
	
////////Address////////////////////
		@Override
		public Address PostCustomer(Address a)
		{
			Address aa=ar.save(a);
			
			return aa;
		}

		@Override
		public List<Address> getAddress() {
			
			List<Address> list1=ar.findAll();
			return list1;
			
		}

		@Override
		public Address updateCustomerAddress(int customerAddrId, Address a)
		{
			Optional<Address> op  = ar.findById(customerAddrId);
			 if(op.isPresent()) 
			 {
				 Address addr= op.get();
				// addr.setCustomerAddrId(a.getCustomerAddrId());
				 addr.setFullAddress(a.getFullAddress());
				 addr.setTaluka(a.getTaluka());
				 addr.setDistrict(a.getDistrict());
				 addr.setState(a.getState());
				 addr.setPincode(a.getPincode());
				  
				 return   ar.save(addr);
			 }
			 else
			 {
				 return null;
			 }
			
		}

		@Override
		public void deleteAdress(int customerAddrId) {
			System.out.println("Id deleted Sucessfully");
			ar.deleteById(customerAddrId);
			
		}

		
		
	
/////////////////////Loan Disbusment/////////////////
		@Override
		public List<LoanDisbusment> getLoanDisbusment() {
			
			List<LoanDisbusment> list=ldr.findAll();
			return list;
			
		}

		@Override
		public LoanDisbusment saveLoanDisburst(LoanDisbusment agreementId) {
			
			LoanDisbusment loan=ldr.save(agreementId);
			return loan;
			
			
			
		}

		@Override
		public LoanDisbusment updateLoanDisburstment(Integer agreementId, LoanDisbusment ld) {
			
			Optional<LoanDisbusment> op  = ldr.findById(agreementId);
			 if(op.isPresent()) 
			 {
				 LoanDisbusment loan=op.get();
				 loan.setAgreementId(ld.getAgreementId());
				 loan.setLoanNo(ld.getLoanNo());
				 loan.setAccountType(ld.getAccountType());
				loan.setAgreementDate(ld.getAgreementDate());
				loan.setAmountPaidDate(ld.getAmountPaidDate());
				loan.setAmountPayType(ld.getAmountPayType());
				loan.setBankName(ld.getBankName());
				loan.setIFSCCode(ld.getIFSCCode());
				loan.setAccountNumber(ld.getAccountNumber());
				loan.setTransferAmount(ld.getTransferAmount());
				loan.setPaymentStatus(ld.getPaymentStatus());
				loan.setTotalAmount(ld.getTotalAmount());
				
				 return   ldr.save(loan);
			 }
			 else
			 {
				 return null;
			 }
		}

		@Override
		public void deleteDisbusment(int agreementId) {
		
				ldr.deleteById(agreementId);
				
			
		}
/////////////////////////////////////Prperty Info//////////////////////
		@Override
		public List<PropertyInfo> getPropertyInfo() {
			List<PropertyInfo> list=pir.findAll();
			return list;
			
		}

		@Override
		public PropertyInfo savePropertyinfi(PropertyInfo p) {
			PropertyInfo info=pir.save(p);
			return info;
			
			
		}

		@Override
		public void deleteProperty(Integer propertyId) {
			pir.deleteById(propertyId);
			
		}

		@Override
		public PropertyInfo updateProperty(Integer propertyId, PropertyInfo p) {
			
			Optional<PropertyInfo> op  = pir.findById(propertyId);
			 if(op.isPresent()) 
			 {
				 PropertyInfo info= op.get();
				 info.setCustomerId(p.getCustomerId());
				 info.setPropertyPrice(p.getPropertyPrice());
				 info.setPropertyType(p.getPropertyType());
				
				 return   pir.save(info);
			 }
			 else
			 {
				 return null;
			 }
			
		}

		@Override
		public List<PropertyInfo> saveDocument(PropertyInfo document) {
			
			pir.save(document);
			return pir.findAll();
		}
/////////////////////////////Sanction Details//////////////////////

		@Override
		public SanctionDetails PostSanction(SanctionDetails sd) {
			
			SanctionDetails sanction=sdr.save(sd);
			return sanction;
			
					}

		@Override
		public List<SanctionDetails> getSanctionDetails() {
			
			List<SanctionDetails> list=sdr.findAll();
			return list;
			
		}

		@Override
		public SanctionDetails updateSanctionDetail(int sanctionId, SanctionDetails sd) {
			
			Optional<SanctionDetails> op  = sdr.findById(sanctionId);
			 if(op.isPresent()) 
			 {
				 SanctionDetails sds= op.get();
				 sds.setSanctionId(sds.getSanctionId());
				 sds.setApplicantName(sd.getApplicantName());
				 sds.setSanctionDate(sd.getSanctionDate());
				 sds.setRateOfInterest(sd.getRateOfInterest());
				 sds.setMonthlyEMIAmt(sd.getMonthlyEMIAmt());
				 sds.setLoanTenure(sd.getLoanTenure());
				 sds.setLoanAmountSanction(sd.getLoanAmountSanction());
				 sds.setInterestType(sd.getInterestType());
				 return   sdr.save(sds);
			 }
			 else
			 {
				 return null;
			 }
			
		}

		@Override
		public void deleteSanctionDetails(int sanctionId) {
			sdr.deleteById(sanctionId);
			
		}
////////////////////Enquiery Details////////////////////////////////

		@Override
		public EnquieryDetail PostEnquiery(EnquieryDetail sd) {
			EnquieryDetail ed=edr.save(sd);
			return null;
		}

		@Override
		public List<EnquieryDetail> getEnquiery() {
			List<EnquieryDetail> list=edr.findAll();
			
			return list;
			
		}

		@Override
		public EnquieryDetail updateEnquiery(int enqiueryId, EnquieryDetail sd) {
			
			Optional<EnquieryDetail> op  = edr.findById(enqiueryId);
			 if(op.isPresent()) 
			 {
				 EnquieryDetail eds= op.get();
				
				 eds.setEnqiueryId(sd.getEnqiueryId());
				 eds.setFirstName(sd.getFirstName());
				 eds.setLastName(sd.getLastName());
				 eds.setMobileNo(sd.getMobileNo());
				 eds.setStatus(sd.getStatus());
				 
				 
				 
				 return   edr.save(eds);
			 }
			 else
			 {
				 return null;
			 }
			
		}

		@Override
		public void deleteEnquiery(int enqiueryId) {
			edr.deleteById(enqiueryId);
			
		}
///////////////////////Email sender///////////////////////////
		@Override
		public void sendEmailWithAttachment(SanctionDetails em, MultipartFile at) {
			
			try
			{
			MimeMessage mm=jms.createMimeMessage();
		MimeMessageHelper mmh=new MimeMessageHelper(mm,true);
			mmh.setFrom(em.getFromEmail());
			//System.out.println(em.getToEmail());
			mmh.setTo(em.getToEmail());
			mmh.setText(em.getTextBody());
			mmh.setSubject(em.getSubject());
			mmh.addAttachment(at.getOriginalFilename(), at);
			mmh.addAttachment(at.getOriginalFilename(), at);
			mmh.addAttachment(at.getOriginalFilename(), at);
			jms.send(mm);
			System.out.println("Email Sent ");
			}
			catch(Exception e3)
			{
				System.out.println("Not Sent");
				e3.printStackTrace();
			}
			
			
			
			
			
		}

		@Override
		public void sendEmail(SanctionDetails e) {
			
			try
			{
				SimpleMailMessage smm=new SimpleMailMessage();
				smm.setFrom(e.getFromEmail());
				smm.setTo(e.getToEmail());
				smm.setText(e.getTextBody());
				smm.setSubject(e.getSubject());
			
				jms.send(smm);
				System.out.println("Mail sent Sucessfully");
			}
			catch(Exception e1)
			{
				System.out.println("Not Sent...");
				e1.printStackTrace();
			}
		}

		@Override
		public void deleteAccountDetails(int accountId) {
			ad.deleteById(accountId);
			
		}

		@Override
		public AccountDetails updateAccountDetails(int accountId, AccountDetails p) {
			
			Optional<AccountDetails> op  = ad.findById(accountId);
			 if(op.isPresent()) 
			 {
				 AccountDetails eds= op.get();
				 eds.setAccountId(p.getAccountId());
				 eds.setAccountHolderName(p.getAccountHolderName());
				 eds.setAccountNo(p.getAccountNo());
				 eds.setAccountType(p.getAccountType());
				eds.setAccountBalance(p.getAccountBalance());				 
				 return   ad.save(eds);
			 }
			 else
			 {
				 return null;
			 }
		}

		@Override
		public AccountDetails PostAccountDetails(AccountDetails ad1) {
			
			AccountDetails sanction=ad.save(ad1);
			return sanction;
			
		}

		@Override
		public List<AccountDetails> getAccountDetails() {
			
			List<AccountDetails> ads=ad.findAll();
			
			return ads;
		}
////////////////////////AllPerson Document////////////////////////////////
		@Override
		public List<AllPersonDocument> saveDocumentCustomer(AllPersonDocument doc) {
		apd.save(doc);
		return apd.findAll();
			
		}
		@Override
		public Customer findCustomer(Integer customerId) {
			
			return hlr.getById(customerId);
		}

		@Override
		public Customer searchCustomer(String  customerFname) {
			
			return hlr.findByCustomerFname(customerFname);
		}

		@Override
		public Guarantor searchGuarantor(String guarantorFname) {
			
			return gr.findByGuarantorFname(guarantorFname);
		}

		@Override
		public Address searchAddress(String fullAddress) {
			
			return ar.findByFullAddress(fullAddress);
		}

		@Override
		public EnquieryDetail searchEnquieryDetail(String firstName) {
			
			return edr.findByFirstName(firstName);
		}

}
		
		
		
		
		
		
	


