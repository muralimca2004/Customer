/**
 * 
 */
package com.maple.it.core.service;

import java.util.List;

import com.maple.it.core.model.Customer;

/**
 * @author murali
 *
 */
public interface ICustomerService {

	public Customer findCustomerByBankAccntNo(int bankAccntNo);
	
	public List<Customer> retrieveCustomerList();
	
	public Customer retrieveCustomer(String passPortNo);
		
	public String sayHello();
}
