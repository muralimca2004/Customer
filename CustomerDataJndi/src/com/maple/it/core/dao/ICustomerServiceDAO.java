/**
 * 
 */
package com.maple.it.core.dao;

import java.util.Date;
import java.util.List;

import com.maple.it.core.model.Customer;
import com.maple.it.core.model.CustomerAccnts;
import com.maple.it.core.model.Transaction;

/**
 * @author murali
 *
 */
public interface ICustomerServiceDAO {//extends CrudRepository<Customer, Long>{

	public String registerNewUserForAccntOpen(Customer customer);
	
	public List<CustomerAccnts> balanceEnquiry(int bankAccntNo);
	
	public List<Transaction> getAccntStatement(int bankAccntNo);
	
	public List<Transaction> getAccntStatementByDate(Date fromDate, Date toDate);
	
	public Customer findCustomerByBankAccntNo(int bankAccntNo);
	
	public Customer retrieveCustomer(String passportNo);
	
	public List<Customer> retrieveCustomerList();
	
	//@Query("select c from Customer c where c.cust_accnt_no = :cust_accnt_no")
	//List<Customer> retrieveCustomer(@Param("cust_accnt_no") String cust_accnt_no);
	
	public String retrieveSortCode(String branchName);
	
	public String checkUidAvailability(String userId);
	
	public List<String> retrieveBranchList();

	public boolean validateUserCredentails(String uid, String password);

}
