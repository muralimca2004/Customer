package com.maple.it.core.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maple.it.core.dao.ICustomerServiceDAO;
import com.maple.it.core.model.Customer;

@Service("iCustomerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerServiceDAO custSvcDAO;
	
	private Logger log = Logger.getLogger(CustomerServiceImpl.class);
	
	public CustomerServiceImpl() {
		
	}
	
	public String sayHello() {
		
		return "Hello.. Good Evening... <b>Now the time is" + new java.util.Date();
	}
	
	public Customer registerUserForAccntOpening(Customer customer){
			
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		return customer;
	}
	
	public List<Customer> retrieveCustomerList(){
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		List<Customer> customerList = custSvcDAO.retrieveCustomerList(); 
		
		return customerList;
	}

	@Override
	public Customer findCustomerByBankAccntNo(int bankAccntNo) {
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		Customer customer = custSvcDAO.findCustomerByBankAccntNo(bankAccntNo);
		
		return customer;
		
	}

	@Override
	public Customer retrieveCustomer(String passPortNo) {
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		Customer customer = custSvcDAO.retrieveCustomer(passPortNo);
		
		return customer;
	}
	
}
