package com.maple.it.core.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maple.it.core.model.Customer;
import com.maple.it.core.model.CustomerAccnts;
import com.maple.it.core.model.Transaction;
import com.maple.it.core.service.ICustomerService;


@Controller
//@RequestMapping("/")
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
	
	/**
	 * This controller method redirects the user to the home page
	 * 
	 * @param model
	 * 
	 * @return
	 */
	@GetMapping(path = {"/", "/index", "/home"})
	public ModelAndView homepage(ModelMap model){
		
		log.info("Inside controller component.." + new Object() {}.getClass().getEnclosingMethod().getName());
		
		return new ModelAndView("index");

	}
	
	/**
	 * This method returns the view for registration
	 * 
	 * @param model
	 * 
	 * @return
	 */
	
	@RequestMapping("/register")	
	public String showRegisterNewUserForAccntOpenForm(Model model) {
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		if(!model.containsAttribute("customerForm")) {
			model.addAttribute("customerForm", new Customer());			
		}
		
		if(!model.containsAttribute("branches")) {
			List<String> branches = populateBranchNames();
			model.addAttribute("branches", branches);		
		}
		
		return "register";
    }
	
	/**
	 * Populates branch names for displaying in registration view
	 * 
	 * @return
	 */
	public List<String> populateBranchNames(){
		
		List<String> branches = custService.retrieveBranchList();
		return branches;
	}
	
	/**
	 * This method retrieves the sort code based on branch
	 * 
	 * @param branchName
	 * @return
	 */
	public String retrieveSortCode(String branchName) {
		
		return custService.retrieveSortCode(branchName);
	}
	
	/**
	 * This method is used for processing the registration form.
	 * 
	 * @param customer
	 * @param bindingResult
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping(path = "/customer/register")
	public String registerNewUserForAccntOpen( @Valid @ModelAttribute("customerForm") Customer customer, 
								BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes ) {
		
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		// Redirect to form page if detected errors
		if(bindingResult.hasErrors()) {
			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customerForm", bindingResult);
		      redirectAttributes.addFlashAttribute("customerForm", customer);
			return "redirect:/register";			
		}
		
		customer.setCust_accnt_type("SAVINGS");
		customer.setCust_accnt_opening_date(new Date());
		customer.setCust_app_submission_date(new Date());
		customer.setCust_bank_sort_code(retrieveSortCode(customer.getCust_bank_branch_name()));
						
		log.info(customer);
		log.info(customer.isCust_enable_netbanking());
		
		String status = custService.registerNewUserForAccntOpen(customer);
		model.addAttribute("status", status);
		
		return "status";
		
    }
	
	/**
	 * This method displays the balance based on the account no.
	 * 
	 * @param bankAccntNo
	 * @return
	 */
	@GetMapping(path = "/customer/balance")
    public List<CustomerAccnts> getAccntBalance(int bankAccntNo) {
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		log.info(bankAccntNo);
		
		List<CustomerAccnts> accntList = custService.balanceEnquiry(bankAccntNo);
		
		accntList.forEach((temp) -> {
			log.debug(temp.getCust_accnt_no());
			log.debug(temp.getCust_accnt_types());
			log.debug("------------------");
		});
		
		return accntList;
	
    }
	
	/**
	 * This method retrieves the account statement
	 * 
	 * @param bankAccntNo
	 * 
	 * @return
	 */	
	@GetMapping(path = "/customer/accntstmt")
    public ModelAndView getAccntStatement(int bankAccntNo) {
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		log.info(bankAccntNo);
		
		List<Transaction> txnList = custService.getAccntStatement(bankAccntNo);
		
		txnList.forEach((temp) -> {
			log.debug(temp.getTxn_amount());
			log.debug(temp.getCust_accnt_no());
			log.debug(temp.getOpening_balance());
			log.debug(temp.getClosing_balance());
			log.debug(temp.getTxn_id());
			log.debug(temp.getTxn_status());
			log.debug(temp.getTxn_time_stamp());
			log.debug("------------------");
		});
		return new ModelAndView("txnstmts", "txnList", txnList);
	
    }
	
	/**
	 * Retrieves the  account statement by date
	 * 
	 * @param fromDate
	 * 
	 * @param toDate
	 * 
	 * @return
	 */
	@GetMapping(path = "/customer/accntstmtbydate")
    public List<Transaction> getAccntStatementByDate(Date fromDate, Date toDate) {
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		List<Transaction> txnList = custService.getAccntStatementByDate(fromDate, toDate);
		
		log.info(txnList);
		
		txnList.forEach((temp) -> {
			log.debug(temp.getTxn_amount());
			log.debug(temp.getCust_accnt_no());
			log.debug(temp.getOpening_balance());
			log.debug(temp.getClosing_balance());
			log.debug(temp.getTxn_id());
			log.debug(temp.getTxn_status());
			log.debug(temp.getTxn_time_stamp());
			log.debug("------------------");
		});
		
		return txnList;
	
    }
	
	
}
