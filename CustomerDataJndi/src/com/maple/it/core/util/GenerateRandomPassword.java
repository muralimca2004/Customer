/**
 * 
 */
package com.maple.it.core.util;

import java.security.SecureRandom;

/**
 * @author murali
 *
 */
public class GenerateRandomPassword {

	
	/**
	 * Default constructor
	 */
	public GenerateRandomPassword() {
		
	}
	
	/** dictionaries used */
    private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*_=+-/[]().?";
    
    private static SecureRandom random = new SecureRandom();

    
    /**
     * Method will generate random string based on the parameters
     * 
     * @param len
     *            the length of the random string
     * 
     * @return the random password
     */
    public static String generatePassword( int len ) {
    	//the dictionary used to generate the password
    	String dic = ALPHA_CAPS + ALPHA + SPECIAL_CHARS + NUMERIC;
    	
    	String result = "";
    	for (int i = 0; i < len; i++) {
    		int index = random.nextInt(dic.length());
    		result += dic.charAt(index);
    	}
    	
    	return result;

    }
    
}
