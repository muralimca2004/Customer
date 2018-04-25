package com.maple.it.core.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.maple.it.core.model.Customer;
import com.maple.it.core.service.ICustomerService;


@RestController
@RequestMapping("/")
@ComponentScan(basePackages = "com.maple.it.core")

public class CustomerController {

	@Autowired
	private ICustomerService custService;
	
	private Logger log = Logger.getLogger(CustomerController.class); 
	
	/**
	 * Default constructor
	 */
	public CustomerController() {
		
	}
		
	@GetMapping("/welcome")
	public String sayHello() {		
		return custService.sayHello();	
	}
	
	// This method will list all existing customers.    
	//@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	@GetMapping(path = "/list")
	public ModelAndView retrieveCustomerList(ModelMap model){
		
		log.info("Inside service component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		List<Customer> customerList = custService.retrieveCustomerList();
		model.addAttribute("customers", customerList);
		for (Customer customer : customerList) {
			
			log.info(customer.getCust_accnt_no());
			log.info(customer.getCust_first_name());
			log.info(customer.getCust_last_name());
			
		}

		return new ModelAndView("allcustomers");
	}
	
	@PostMapping(path = "/customer/register")
    public Customer registerNewUserForAccntOpen(@RequestBody Customer customer) {
		log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		log.info(customer.getCust_first_name());
		
		customer.setCust_accnt_type("CURRENT");
		log.info(customer);
		
		return customer;
	
    }
	
	@GetMapping(path = "/customer/findbyaccntno/{accntNo}")
	@ResponseBody
	public Customer findCustomerByBankAccntNo(@PathVariable("accntNo") int bankAccntNo) {
		
		log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		Customer customer = custService.findCustomerByBankAccntNo(bankAccntNo);
		return customer;
	}
	
	@GetMapping(path = "/customer/{passPortNo}")
	@ResponseBody
	public Customer retrieveCustomer(@PathVariable("passPortNo") String passPortNo) {
		
		log.info("Inside... "+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		Customer customer = custService.retrieveCustomer(passPortNo);
		log.info(customer.getCust_passport_no());
		log.info(customer.getCust_accnt_no());

		return customer;
	}
}
