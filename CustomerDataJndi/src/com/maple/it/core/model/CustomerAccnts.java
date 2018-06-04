package com.maple.it.core.model;

import java.util.Arrays;

import javax.persistence.Column;

public class CustomerAccnts {
	
	@Column(name = "cust_accnt_no", unique = true, nullable = false)
	private int cust_accnt_no[];
	
	private String cust_accnt_types[];
	
	public CustomerAccnts() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the cust_accnt_no
	 */
	public int[] getCust_accnt_no() {
		return cust_accnt_no;
	}

	/**
	 * @return the cust_accnt_types
	 */
	public String[] getCust_accnt_types() {
		return cust_accnt_types;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomerAccnts [cust_accnt_no=" + Arrays.toString(cust_accnt_no) + ", cust_accnt_types="
				+ Arrays.toString(cust_accnt_types) + "]";
	}

	
}
