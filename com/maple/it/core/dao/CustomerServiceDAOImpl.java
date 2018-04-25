/**
 * 
 */
package com.maple.it.core.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maple.it.core.model.Customer;

/**
 * @author murali
 *
 */

@Repository
public class CustomerServiceDAOImpl implements ICustomerServiceDAO {

	private Logger log = Logger.getLogger(CustomerServiceDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getHibernateSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * Default Constructor
	 */
	public CustomerServiceDAOImpl() {

	}
	

	@SuppressWarnings("unchecked")
	public List<Customer> retrieveCustomerList() {
		
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		
		List <Customer> customerList = getHibernateSession().createQuery("from Customer").list();
		log.info("Retrieved CustomerList" + customerList.get(0));
		
		return customerList;
		}

	public Customer retrieveCustomer(String passPortNO) {
			
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		
		Customer customer = (Customer)getHibernateSession().createQuery(
				"from Customer where cust_passport_no = :passPortNO").setString("passPortNO", passPortNO).uniqueResult();
		
		log.info("Retrieved CustomerList" + customer);
						
		return customer;
		}
	
	public Customer findCustomerByBankAccntNo(int bankAccntNo) {

		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		
		Customer customer = (Customer)getHibernateSession().createQuery(
				"from Customer where cust_accnt_no= :bankAccntNo").setInteger("bankAccntNo", bankAccntNo).uniqueResult();
		
		log.info("Retrieved CustomerList" + customer);
		
		return customer;
	}

}
