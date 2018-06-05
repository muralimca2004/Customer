/**
 * 
 */
package com.maple.it.core.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maple.it.core.model.Customer;
import com.maple.it.core.model.CustomerAccnts;
import com.maple.it.core.model.NetBanking;
import com.maple.it.core.model.Transaction;
import com.maple.it.core.util.GenerateRandomPassword;
import com.maple.it.core.util.GenerateRandomPin;

/**
 * @author murali
 *
 */

@Repository
public class CustomerServiceDAOImpl implements ICustomerServiceDAO {

	private Logger log = Logger.getLogger(CustomerServiceDAOImpl.class);
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	protected EntityManager getEntityManager() {
		//log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		return entityManagerFactory.createEntityManager();
	}
	
	public String registerNewUserForAccntOpen(Customer customer) {
		
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("Inside... "+ getEntityManager().toString());
		
		try {
			log.info("<<-----------------------------");
			log.info(customer);
			log.info("----------------------------->>");
			EntityManager em = getEntityManager();
			
			if(!customer.isCust_enable_netbanking()) {
				customer.setCust_netbanking_id("NOT ENABLED");
				em.getTransaction().begin();
				em.persist(customer);			
				em.flush();
				em.getTransaction().commit();
				
				return "SUCCESS";

			} 
			
			if(customer.isCust_enable_netbanking()) {
				em.getTransaction().begin();
				//https://www.thoughts-on-java.org/persist-save-merge-saveorupdate-whats-difference-one-use/
				
				//generate Password and Pin
				String passwd = GenerateRandomPassword.generatePassword(8);
				String pin = GenerateRandomPin.genRandomPin(6);
				
				NetBanking nb = new NetBanking();
				nb.setCust_netbanking_id(customer.getCust_netbanking_id());
				nb.setCust_netbanking_passwd(passwd);
				nb.setCust_netbanking_pin(pin);
				nb.setCustomer(customer);
				customer.setNetbanking(nb);
				
				em.persist(customer);
				em.flush();
				em.getTransaction().commit();
			}
		}catch (Exception e) {
			
			log.error(e);
					
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCCESS";
	}

	@SuppressWarnings("unchecked")
	public List<CustomerAccnts> balanceEnquiry(int bankAccntNo) {

		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
				
		List<CustomerAccnts> accntList = getEntityManager().createQuery("from Account where fk_cust_accnt_no =:bankAccntNo").setParameter("bankAccntNo", bankAccntNo).getResultList();
		
		return accntList;
	}

	@SuppressWarnings("unchecked")
	public List<Transaction> getAccntStatement(int bankAccntNo) {

		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
				
		List<Transaction> txnList = getEntityManager().createQuery("from Transaction where cust_accnt_no = :bankAccntNo").setParameter("bankAccntNo", bankAccntNo).getResultList();
		
		return txnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transaction> getAccntStatementByDate(Date fromDate, Date toDate) {

		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
				
		List<Transaction> txnList = getEntityManager().createQuery("from Transaction where txn_time_stamp >= :fromDate AND txn_time_stamp <= :toDate")
													  .setParameter("fromDate", fromDate)
													  .setParameter("toDate", toDate)
													  .getResultList();
		
		return txnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> retrieveCustomerList() {
		
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		
		List <Customer> customerList = getEntityManager().createQuery("from Customer").getResultList();
		log.info("Retrieved CustomerList" + customerList.get(0));
		
		return customerList;
		}

	public Customer retrieveCustomer(String passPortNO) {
			
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
						
		Customer customer = (Customer)getEntityManager().createQuery(
				"from Customer where cust_passport_no = :passPortNO").setParameter("passPortNO", passPortNO).getResultList().get(0);
				
		log.info("Retrieved CustomerList" + customer);
						
		return customer;
		}
	
	public Customer findCustomerByBankAccntNo(int bankAccntNo) {

		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
				
		Customer customer = (Customer)getEntityManager().createQuery(
				"from Customer where cust_accnt_no= :bankAccntNo").setParameter("bankAccntNo", bankAccntNo).getResultList().get(0);
		
		log.info("Retrieved CustomerList" + customer);
		
		
		return customer;
	}

	@Override
	public String retrieveSortCode(String branchName) {
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		
		String branch_sortcode = (String)getEntityManager().createQuery("SELECT branch_sortcode from Bank where branch_name= :branchName").setParameter("branchName", branchName).getSingleResult();
		
		log.info("Retrieved Branch SortCode" + branch_sortcode);
		
		return branch_sortcode;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> retrieveBranchList() {
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		
		List<String> branchList = getEntityManager().createQuery("SELECT branch_name FROM Bank").getResultList();
		
		return branchList;
	}
	
	/**
	 * Check uniqueness of the Uid
	 * 
	 * @param userId
	 * 
	 * @return	String
	 */
	@SuppressWarnings("unchecked")
	public String checkUidAvailability(String userId) {
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		log.info("user input is:" + userId);
		
		try {
				String id = (String)getEntityManager().createQuery("select cust_netbanking_id from NetBanking where cust_netbanking_id= :netbanking_id").setParameter("netbanking_id", userId).getSingleResult();
				log.info("id is:" + id);
				
				List<NetBanking> list = getEntityManager().createQuery(
						"from NetBanking where cust_netbanking_id= :netbanking_id").setParameter("netbanking_id", userId).getResultList();
				
				if( list.isEmpty() ) {
					return "available";
				}
				
				return "notavailable";
				
			}catch (NoResultException e) {
				log.info("NO RESULTS FOUND");
				return "available";
			}catch (IndexOutOfBoundsException e) {
				log.info("NO RESULTS FOUND");
				return "available";
			}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateUserCredentails(String uid, String password) {
		log.info("Inside.. " + new Object() {}.getClass().getEnclosingMethod().getName());
		try {
			List<NetBanking> list = getEntityManager().createQuery(
					"from NetBanking where cust_netbanking_id= :netbanking_id").setParameter("netbanking_id", uid).getResultList();
		
			if( list.isEmpty() || list.size()>1) {
				return false;
			}
			
			return true;
			
		}catch (NoResultException e) {
			log.info(e.getMessage());
			log.info("No matching results found for the userId:" + uid);
			return false;
		}catch (IndexOutOfBoundsException e) {
			log.info(e.getMessage());
			log.info("No matching results found for the userId:" + uid);
			return false;
		}
		
	}
}
