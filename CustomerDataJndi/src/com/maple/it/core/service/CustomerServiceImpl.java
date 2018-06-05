package com.maple.it.core.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maple.it.core.dao.ICustomerServiceDAO;
import com.maple.it.core.model.Customer;
import com.maple.it.core.model.CustomerAccnts;
import com.maple.it.core.model.Transaction;

@Service("iCustomerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerServiceDAO custSvcDAO;
	
	private Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
	public CustomerServiceImpl() {
		
	}
	
	@Override
	public String registerNewUserForAccntOpen(Customer customer) {
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		String status = custSvcDAO.registerNewUserForAccntOpen(customer);
		
		return status;
	}

	@Transactional(readOnly = true)
	@Override
	public List<CustomerAccnts> balanceEnquiry(int bankAccntNo) {
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		List<CustomerAccnts> accntList = custSvcDAO.balanceEnquiry(bankAccntNo);
		
		return accntList;
	}
	
	@Transactional(readOnly = true)
	public List<Transaction> getAccntStatement(int bankAccntNo) {
		

		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		List<Transaction> txnList = custSvcDAO.getAccntStatement(bankAccntNo);
		
		return txnList;
	}
	
	@Transactional(readOnly = true)
	public List<Transaction> getAccntStatementByDate(Date fromDate, Date toDate) {

		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		List<Transaction> txnList = custSvcDAO.getAccntStatementByDate(fromDate, toDate);
		
		return txnList;
	}
	
	@Transactional(readOnly = true)
	public List<Customer> retrieveCustomerList(){
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		List<Customer> customerList = custSvcDAO.retrieveCustomerList(); 
		
		return customerList;
	}

	@Transactional(readOnly = true)
	@Override	
	public Customer findCustomerByBankAccntNo(int bankAccntNo) {
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		Customer customer = custSvcDAO.findCustomerByBankAccntNo(bankAccntNo);
		
		return customer;
		
	}
	
	@Transactional(readOnly = true)
	@Override
	public Customer retrieveCustomer(String passPortNo) {
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		Customer customer = custSvcDAO.retrieveCustomer(passPortNo);
		
		return customer;
	}

	@Transactional(readOnly = true)
	@Override
	public String retrieveSortCode(String branchName) {
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		return custSvcDAO.retrieveSortCode(branchName);
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<String> retrieveBranchList() {
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		return custSvcDAO.retrieveBranchList();
	}
	
	@Transactional(readOnly = true)
	@Override
	public String checkUidAvailability(String userId) {
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		return custSvcDAO.checkUidAvailability(userId);
	}

	@Override
	public boolean validateUserCredentails(String uid, String password) {
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		return custSvcDAO.validateUserCredentails(uid, password);
	}

	
}
