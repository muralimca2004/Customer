/**
 * 
 */
package com.maple.it.core.dao;

import java.util.List;

import com.maple.it.core.model.Customer;

/**
 * @author murali
 *
 */
public interface ICustomerServiceDAO {//extends CrudRepository<Customer, Long>{
	
	public Customer findCustomerByBankAccntNo(int bankAccntNo);
	
	public Customer retrieveCustomer(String passportNo);
	
	public List<Customer> retrieveCustomerList();
	
	//@Query("select c from Customer c where c.cust_accnt_no = :cust_accnt_no")
	//List<Customer> retrieveCustomer(@Param("cust_accnt_no") String cust_accnt_no);
	
	

}
