package com.maple.it.core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;


public class PinEncryptionUtil {
	private final static Logger log = Logger.getLogger(PinEncryptionUtil.class);
	
	/**
	 * 
	 * @param actualPin
	 *        	PIN stored in database
	 * @param randomList
	 * 			Random PIN positions to be validated
	 * @param inputPin
	 * 			Input PIN corresponding to random positions
	 * @return
	 */
	public static boolean compareHash( String actualPin, List<Integer> randomList, String inputPin){
	boolean matched = true;
	try {		
	      String delim = "||";	      
	      String actualPinHash = computeHashUtil(actualPin);
	      String [] tokensArray = mySplit(actualPinHash, delim);
	  
	  while (matched) {
		  /*int digit1 = randomList.get(0).intValue();
	      int digit2 = randomList.get(1).intValue();
	      int digit3 = randomList.get(2).intValue();*/
		  int digit1 = 3;
	      int digit2 = 6;
	      int digit3 = 1;
	      
	      String inputPinHash = computeHashUtil(inputPin);
	      String[] inputTokensArray = mySplit(inputPinHash, delim);
	      
	      if( (inputTokensArray[0].equals(tokensArray[digit1-1])) && 
	    		  (inputTokensArray[1].equals(tokensArray[digit2-1])) && (inputTokensArray[2].equals(tokensArray[digit3-1])) ){
	    	  
	    	  log.info( inputTokensArray[0] +" ===> "+ tokensArray[digit1-1]);
	    	  log.info( inputTokensArray[1] +" ===> "+ tokensArray[digit2-1]);
	    	  log.info( inputTokensArray[2] +" ===> "+ tokensArray[digit3-1]);
	    	  
	    	  log.info("PIN matched!");
	    	  matched = false;
	      }
	     else
	        log.info("Wrong, try again...!");
	      }
		}catch (Exception e) {
		
		 e.printStackTrace();
		}
	return matched;
	}
	
	/**
	 * 
	 * @param str
	 * 			
	 * @return
	 * 
	 * @throws Exception
	 */
	public static byte[] computeHash(String str)throws Exception {
	     java.security.MessageDigest d =null;
	     //d = java.security.MessageDigest.getInstance("sha1");
	     d = java.security.MessageDigest.getInstance("SHA-256");
	     d.reset();
	     d.update(str.getBytes());
	     return  d.digest();
	 }
	  
	/**
	 * 
	 * @param byteArray
	 * 		
	 * @return
	 */
	 public static String byteArrayToHexString(byte[] byteArray){
	     StringBuffer sb = new StringBuffer(byteArray.length * 2);
	     for (int i = 0; i < byteArray.length; i++){
	       int v = byteArray[i] & 0xff;
	       if (v < 16) {
	         sb.append('0');
	       }
	       sb.append(Integer.toHexString(v));
	     }
	     return sb.toString().toUpperCase();
	 }
	 
	 /**
	  * 
	  * @param pin
	  * 		Input Pin to compute the hash
	  * 	
	  * @return
	  */
	 public static String computeHashUtil(String pin){
		 String finalHash ="";
		 String[] values = pin.split("");
		 String tempHash = "";
		 
		 for(int index=0; index <values.length; index++){	      	  		  
			try {
				tempHash = byteArrayToHexString(computeHash(values[index])) +"||";
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	  		 //log.debug("Hashing of the digit:" + values[index] +"  - - -  "+ "is : " + tempHash);
	  		 finalHash += tempHash;	  		
	  	  }
	  	  
		 log.debug("the computed final hash (hex string) : " + finalHash);
	  	  
		 return finalHash;
	 }
	 
	 	/**
		 * Utility function to split a String into tokens
		 * @param aString The String to split
		 * @param delim The delimiters 
		 * @return Array of String Objects containing the Tokens
		 */
		public static String[] mySplit(String aString, String delim)
		{
			StringTokenizer st = new StringTokenizer(aString, delim);
			ArrayList<Object> tokens = new ArrayList<Object>();
			while(st.hasMoreElements())
			{
				tokens.add(st.nextElement());
			}
			String [] tokensArray = new String[tokens.size()];
			tokens.toArray(tokensArray);
			
			return tokensArray;
		}
		
		/**
		 * This function is used for converting the digits to the Words  
		 */
		public String digitToString(String randomPinDigit){
			
			if(randomPinDigit == "1"){
				return " FIRST ";
			}else if(randomPinDigit == "2"){
				return " SECOND ";
			}else if(randomPinDigit == "3"){
				return " THIRD ";
			}else if(randomPinDigit == "4"){
				return " FOURTH ";
			}else if(randomPinDigit == "5"){
				return " FIFTH ";
			}else if(randomPinDigit == "6"){
				return " SIXTH ";
			}
			return null;
	   	 }
		
		public String digitToWord(Integer randomPinDigit){
			
			if(randomPinDigit == 1){
				return " FIRST ";
			}else if(randomPinDigit == 2){
				return " SECOND ";
			}else if(randomPinDigit == 3){
				return " THIRD ";
			}else if(randomPinDigit == 4){
				return " FOURTH ";
			}else if(randomPinDigit == 5){
				return " FIFTH ";
			}else if(randomPinDigit == 6){
				return " SIXTH ";
			}
			return null;
	   	 }
		
		/*public static void main(String arg[]) {
			
			compareHash("982741", GenerateRandomPin.genRandomNum(3), "219");
		}*/
}
