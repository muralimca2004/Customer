package com.maple.it.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class GenerateRandomPin {
	
	private final static Logger log = Logger.getLogger(GenerateRandomPin.class);
	
	/**
	 * 
	 * @param numbers
	 * 			List of Numbers from which the pin will be generated
	 *  
	 * @param randomPinlength
	 * 			length of the Pin to be generated
	 * 
	 * @return
	 */
	public static List<Integer> get(List<Integer> numbers, int randomPinlength) { 
		List<Integer> list = new ArrayList<Integer>(numbers);
		List<Integer> randomList = new ArrayList<Integer>();
		Random rd = new Random();
	    for (int i = 0; i < randomPinlength; i++) {
	    	int index = (int) (rd.nextDouble() * list.size());
	    	randomList.add(list.get(index));
	    	list.remove(index);
	    	}
	    return randomList;
	}
	
	/**
	 * Method used to generate random PIN
	 * 
	 * @param randomPinlength
	 * 			length of the PIN to be generated
	 * @return
	 */
	public static String genRandomPin(int randomPinlength){
		List<Integer> ls = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> randomList = get(ls, randomPinlength);
		
		StringBuilder sb = new StringBuilder();
		randomList.forEach(sb::append);
		String hashOfPin = PinEncryptionUtil.computeHashUtil(sb.toString());
		log.info("hashOfPin is : "+ hashOfPin);
		
		return hashOfPin;
	}
	
	
	/**
	 * Method used for generating the random positions of 6 digit PIN
	 * 
	 * @param noOfRandomNumbers
	 * 			PIN positions to be filled by the user
	 * @return
	 */
	public static List<Integer> genRandomNum(int noOfRandomNumbers){ 

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		List<Integer> randomList = new ArrayList<Integer>();
		
		Random rd = new Random();
	    
		for (int i = 0; i < noOfRandomNumbers; i++) {
	    	int index = (int) (rd.nextDouble() * list.size());
	    	randomList.add(list.get(index));
	    	list.remove(index);
	    	}
	    
	    return randomList;
	}
	
	/*public static void genRandomNum(){ 

		Set<Integer> set = new TreeSet<Integer>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 6; i++){
			numbers.add(i+1);
		}
		Collections.shuffle(numbers);
		for(int j =0; j < 3; j++){
			set.add(numbers.get(j));
		} 		
		log.info(set);
	}
	 */


	
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		int k;
		for(int j=0; j<9; j++){
			List<Integer> randomList = genRandomPin(6);
			for(k=0; k<randomList.size(); k++){
				System.out.print(randomList.get(k));
			}
			System.out.println();
		}
		
			//Test 'n' times for randomness
			for(int j=0; j<20; j++){
				List<Integer> randomList = genRandomNum(3);
				for(int k=0; k<randomList.size(); k++){
					System.out.print(randomList.get(k));
				}System.out.println();
			}
			
	}*/
	
}