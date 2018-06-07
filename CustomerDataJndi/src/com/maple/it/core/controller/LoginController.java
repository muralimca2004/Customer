/**
 * 
 */
package com.maple.it.core.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maple.it.core.model.LoginForm;
import com.maple.it.core.service.ICustomerService;

/**
 * @author murali
 *
 */
@Controller
@ComponentScan(basePackages = "com.maple.it.core")
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private ICustomerService custService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(path = "/customer/login")
	public String showCustomerLoginForm(Model model) {
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		if(!model.containsAttribute("user")) {
			model.addAttribute("user", new LoginForm());			
		}
		return "th_login";
	}
	
	/**
	 * Validates login credentials for the user
	 * 
	 * @param user
	 * @param bindingResult
	 * @param model
	 * 
	 * @return	returns to the loginSuccess page
	 */
	@PostMapping(path = "/processUsrLogin")
	public String validateUserLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		
		log.info("Inside controller method..."+ new Object() {}.getClass().getEnclosingMethod().getName());
		
		//Redirect to form page if detected errors
		if(bindingResult.hasErrors()) {
			  redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", bindingResult);
		      redirectAttributes.addFlashAttribute("loginForm", loginForm);
			return "redirect:/customer/login";			
		}
		
		if(!custService.authenticate(
				loginForm.getUid(), loginForm.getPassword())) {
			log.info("Login Failed for the user:" + loginForm.getUid());
			return "th_login";
		}
		log.info("Login Success for the user:" + loginForm.getUid());
		return "th_loginSuccess";
	}
}
