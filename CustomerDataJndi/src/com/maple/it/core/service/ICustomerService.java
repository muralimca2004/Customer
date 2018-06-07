/**
 * 
 */
package com.maple.it.core.service;

import java.util.Date;
import java.util.List;

import com.maple.it.core.model.Customer;
import com.maple.it.core.model.CustomerAccnts;
import com.maple.it.core.model.Transaction;

/**
 * @author murali
 *
 */
public interface ICustomerService {
	
	public String registerNewUserForAccntOpen(Customer customer);
	
	public List <CustomerAccnts> balanceEnquiry(int bankAccntNo);
	
	public List<Transaction> getAccntStatement(int bankAccntNo);
	
	public List<Transaction> getAccntStatementByDate(Date fromDate, Date toDate);
	
	public Customer findCustomerByBankAccntNo(int bankAccntNo);
	
	public List<Customer> retrieveCustomerList();
	
	public Customer retrieveCustomer(String passPortNo);
	
	public String retrieveSortCode(String branchName);
	
	public String checkUidAvailability(String userId);
	
	public List<String> retrieveBranchList();

	public boolean authenticate(String uid, String password);
}
