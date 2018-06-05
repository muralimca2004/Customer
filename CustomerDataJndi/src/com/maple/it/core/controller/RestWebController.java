/**
 * 
 */
package com.maple.it.core.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.maple.it.core.model.RestWrapperDTO;
import com.maple.it.core.service.ICustomerService;

/**
 * @author murali
 *
 */

@RestController
public class RestWebController {

	@Autowired
	private ICustomerService custService;
	private Logger log = Logger.getLogger(RestWebController.class);
	
	/**
	 * Default constructor
	 */
	public RestWebController() {
		
	}
	
	@PostMapping(produces=MediaType.TEXT_PLAIN_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, value="/customer/checkuid")
	public ResponseEntity<String> checkCustomerId(@RequestBody String userId) {
		
		log.info("UserInput Id to check: " + userId);
				
		String status = custService.checkUidAvailability(userId.replace("\"", ""));
		
		log.info("is User Exist? " + status);
				 
		return ResponseEntity
	            .ok()
	            .body(status);

	}

	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE, value="/customer/checkuid2")
	public @ResponseBody ResponseEntity<Object> checkCustomerId2(@RequestBody String userId) {
		
		log.info("UserInput Id to check: " + userId);
		
		String status = custService.checkUidAvailability(userId);
		log.info("is User Exist? " + status);
		
		RestWrapperDTO wrapperDTO = new RestWrapperDTO();
		if(status.equals("available")) {
			
			wrapperDTO.setSuccess(true);
		}else {
			wrapperDTO.setSuccess(false);
		}
		
		return new ResponseEntity<Object>(wrapperDTO, HttpStatus.OK);


	}

	
	@PostMapping(produces="application/json; charset=UTF-8", value="/customer/checkuid1")
	public @ResponseBody ResponseEntity<Object> checkCustomerIdJSON(String userId) {
		
		log.info("is UserInout Exist? " + userId);
		
		String status = custService.checkUidAvailability(userId);
		
		log.info("is User Exist? " + status);
		
		RestWrapperDTO wrapperDTO = new RestWrapperDTO();
		if(status.equals("available")) {
			
			wrapperDTO.setSuccess(true);
		}else {
			wrapperDTO.setSuccess(false);
		}
		 
		return new ResponseEntity<Object>(wrapperDTO, HttpStatus.OK);

	}

}
