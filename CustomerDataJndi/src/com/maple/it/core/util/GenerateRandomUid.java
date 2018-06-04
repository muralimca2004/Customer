package com.maple.it.core.util;

import java.security.SecureRandom;

public class GenerateRandomUid {

	public GenerateRandomUid() {
		
	}
		
	// dictionary used for generating UUID
	static final private String DICTIONARY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*_=+/[]()?";
	
	// dictionary used for generating Activation Code
	static final private String DICTIONARY_ACTIVATION_CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	private static SecureRandom random = new SecureRandom();
	
    /**
     * Method will generate random uid string based on the parameters
     * 
     * @param length
     * 			the length of the random string
     * 
     * @return the random userId 
     */
	public static String generateRandomUid(int length){

		StringBuilder sb = new StringBuilder();
	    
	    for (int i = length; i >0; i--) {
	        	//generate randomChar and add to StringBuilder
	        sb.append(DICTIONARY.charAt(random.nextInt(DICTIONARY.length())));
	    }
	    return sb.toString();
	}
	
	/**
     * Method will generate random activation code string based on the parameters
     * 
     * @param length
     * 			the length of the random string
     * 
     * @param spacing
     * @param spacerChar
     * 
     * @return the random userId 
     */
	public static String generateActivationCode(int length, int spacing, char spacerChar){
		
		StringBuilder sb = new StringBuilder();
	    int spacer = 0;
	    
	    for (int i = length; i >0; i--) {
	    	if(spacer == spacing){
	            sb.append(spacerChar);
	            spacer = 0;
	        }
	    	spacer++;
	
	    	//generate randomChar and add to StringBuilder
	        sb.append(DICTIONARY_ACTIVATION_CODE.charAt(random.nextInt(DICTIONARY_ACTIVATION_CODE.length())));
	    }
	    return sb.toString();
	}
	
	/*public static void main(String[] args) {
		
		System.out.println(generateRandomUid(9));
		System.out.println(generateActivationCode(24, 8, '-'));
	}
*/
}
