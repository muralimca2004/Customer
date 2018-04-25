/**
 * 
 */
package com.maple.it.core.model;

/**
 * @author murali
 *
 */
public interface PersonData {

	public String sortCode="";
	public String name="";
	public String foreName="";
	public String lastName="";
	public String address="";
	public int id=0;
	public int pin=0;
	public int cardNo=0;
	public int accntNo=0;
	
	public boolean processUserData();
	
	
}
