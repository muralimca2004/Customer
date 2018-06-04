package com.maple.it.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "branch_no", unique = true, updatable = false, nullable = false)
	private int branch_no;
	
	@Column(name = "branch_name", unique = true, nullable = false)
	private String branch_name;
	
	@Column(name = "branch_address_line1", unique = true, nullable = false)
	private String branch_address_line1;
	
	@Column(name = "branch_address_line2", unique = true, nullable = false)
	private String branch_address_line2;
	
	@Column(name = "branch_postcode", unique = true, nullable = false)
	private String branch_postcode;
	
	@Column(name = "branch_sortcode", unique = true, nullable = false)
	private String branch_sortcode;
	
	public Bank() {
		
	}
	
	
	/**
	 * @param branch_no
	 * @param branch_name
	 * @param branch_address_line1
	 * @param branch_address_line2
	 * @param branch_postcode
	 * @param branch_sortcode
	 */
	public Bank(int branch_no, String branch_name, String branch_address_line1, String branch_address_line2,
			String branch_postcode, String branch_sortcode) {
		super();
		this.branch_no = branch_no;
		this.branch_name = branch_name;
		this.branch_address_line1 = branch_address_line1;
		this.branch_address_line2 = branch_address_line2;
		this.branch_postcode = branch_postcode;
		this.setBranch_sortcode(branch_sortcode);
	}


	/**
	 * @param branch_no the branch_no to set
	 */
	public void setBranch_no(int branch_no) {
		this.branch_no = branch_no;
	}

	/**
	 * @param branch_name the branch_name to set
	 */
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	/**
	 * @param branch_address_line1 the branch_address_line1 to set
	 */
	public void setBranch_address_line1(String branch_address_line1) {
		this.branch_address_line1 = branch_address_line1;
	}

	/**
	 * @param branch_address_line2 the branch_address_line2 to set
	 */
	public void setBranch_address_line2(String branch_address_line2) {
		this.branch_address_line2 = branch_address_line2;
	}

	/**
	 * @param branch_postcode the branch_postcode to set
	 */
	public void setBranch_postcode(String branch_postcode) {
		this.branch_postcode = branch_postcode;
	}

	/**
	 * @param branch_sortcode the branch_sortcode to set
	 */
	public void setBranch_sortcode(String branch_sortcode) {
		this.branch_sortcode = branch_sortcode;
	}


	/**
	 * @return the branch_no
	 */
	public int getBranch_no() {
		return branch_no;
	}

	/**
	 * @return the branch_name
	 */
	public String getBranch_name() {
		return branch_name;
	}

	/**
	 * @return the branch_address_line1
	 */
	public String getBranch_address_line1() {
		return branch_address_line1;
	}

	/**
	 * @return the branch_address_line2
	 */
	public String getBranch_address_line2() {
		return branch_address_line2;
	}

	/**
	 * @return the branch_postcode
	 */
	public String getBranch_postcode() {
		return branch_postcode;
	}

	/**
	 * @return the branch_sortcode
	 */
	public String getBranch_sortcode() {
		return branch_sortcode;
	}

		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bank [branch_no=" + branch_no + ", branch_name=" + branch_name + ", branch_address_line1="
				+ branch_address_line1 + ", branch_address_line2=" + branch_address_line2 + ", branch_postcode="
				+ branch_postcode + ", toString()=" + super.toString() + "]";
	}

	
}
