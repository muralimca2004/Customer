/**
 * 
 */
package com.maple.it.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.maple.it.core.model.Customer;
import com.maple.it.core.service.ICustomerService;

/**
 * @author murali
 *
 */

@Controller
@ComponentScan(basePackages = "com.maple.it.core")
public class AdminController {
	
	@Autowired
	private ICustomerService custService;
	
	private Logger log = Logger.getLogger(AdminController.class);
			
	/**
	 * This method will list all existing customers.
	 * 
	 * @param model
	 * 
	 * @return
	 */
	
	@GetMapping(path = "/list")
	public ModelAndView retrieveCustomerList(ModelMap model){
		
		log.info("Inside controller component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		List<Customer> customerList = custService.retrieveCustomerList();
		model.addAttribute("customers", customerList);
		for (Customer customer : customerList) {
			
			log.info(customer.getCust_accnt_no());
			log.info(customer.getCust_first_name());
			log.info(customer.getCust_last_name());
			
		}

		return new ModelAndView("allcustomers");
	}
	
	/**
	 * Finds the customer record based on account no
	 * 
	 * @param bankAccntNo
	 * 
	 * @return
	 */
	@GetMapping(path = "/customer/findbyaccntno/{accntNo}")
	@ResponseBody
	public Customer findCustomerByBankAccntNo(@PathVariable("accntNo") int bankAccntNo) {
		
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		Customer customer = custService.findCustomerByBankAccntNo(bankAccntNo);
		return customer;
	}
	
	/**
	 * Finds the customer record based on passport no
	 * 
	 * @param passPortNo
	 * 
	 * @return
	 */	
	@GetMapping(path = "/customer/findbypassport/{passPortNo}")
	@ResponseBody
	public Customer retrieveCustomerByPassportNo(@PathVariable("passPortNo") String passPortNo) {
		
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		Customer customer = custService.retrieveCustomer(passPortNo);
		log.info(customer.getCust_passport_no());
		log.info(customer.getCust_accnt_no());

		return customer;
	}
}
