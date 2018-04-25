/**
 * 
 */
package com.maple.it.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;

import org.springframework.data.annotation.CreatedDate;


/**
 * @author murali
 *
 */

@Entity
@Table(name="customer")
public class Customer {

	

	private int cust_age;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cust_accnt_no", unique = true, nullable = false)
	private int cust_accnt_no;  //cust_bank_accnt_no ??
	
	private String cust_accnt_type;
	private String cust_last_name;
	private String cust_first_name;
	private String cust_address_line1;
	private String cust_address_line2;	
	private String cust_gender;
	private String cust_passport_no;
	private String cust_post_code;
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date cust_app_submission_date;	
	private Date cust_accnt_opening_date;
	private String cust_bank_sort_code;
	private String cust_bank_branch_name;
	private String cust_address_town;
	private String cust_address_county;	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [cust_age=" + cust_age + ", cust_accnt_no=" + cust_accnt_no + ", cust_accnt_type="
				+ cust_accnt_type + ", cust_last_name=" + cust_last_name + ", cust_first_name=" + cust_first_name
				+ ", cust_address_line1=" + cust_address_line1 + ", cust_address_line2=" + cust_address_line2
				+ ", cust_gender=" + cust_gender + ", cust_passport_no=" + cust_passport_no + ", cust_post_code="
				+ cust_post_code + ", cust_app_submission_date=" + cust_app_submission_date
				+ ", cust_accnt_opening_date=" + cust_accnt_opening_date + ", cust_bank_sort_code="
				+ cust_bank_sort_code + ", cust_bank_branch_name=" + cust_bank_branch_name + ", cust_address_town="
				+ cust_address_town + ", cust_address_county=" + cust_address_county + "]";
	}

	/**
	 * @return the cust_age
	 */
	public int getCust_age() {
		return cust_age;
	}

	/**
	 * @param cust_age the cust_age to set
	 */
	public void setCust_age(int cust_age) {
		this.cust_age = cust_age;
	}

	/**
	 * @return the cust_accnt_no
	 */
	public int getCust_accnt_no() {
		return cust_accnt_no;
	}

	/**
	 * @param cust_accnt_no the cust_accnt_no to set
	 */
	public void setCust_accnt_no(int cust_accnt_no) {
		this.cust_accnt_no = cust_accnt_no;
	}

	/**
	 * @return the cust_accnt_type
	 */
	public String getCust_accnt_type() {
		return cust_accnt_type;
	}

	/**
	 * @param cust_accnt_type the cust_accnt_type to set
	 */
	public void setCust_accnt_type(String cust_accnt_type) {
		this.cust_accnt_type = cust_accnt_type;
	}

	/**
	 * @return the cust_last_name
	 */
	public String getCust_last_name() {
		return cust_last_name;
	}

	/**
	 * @param cust_last_name the cust_last_name to set
	 */
	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}

	/**
	 * @return the cust_first_name
	 */
	public String getCust_first_name() {
		return cust_first_name;
	}

	/**
	 * @param cust_first_name the cust_first_name to set
	 */
	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}

	/**
	 * @return the cust_address_line1
	 */
	public String getCust_address_line1() {
		return cust_address_line1;
	}

	/**
	 * @param cust_address_line1 the cust_address_line1 to set
	 */
	public void setCust_address_line1(String cust_address_line1) {
		this.cust_address_line1 = cust_address_line1;
	}

	/**
	 * @return the cust_address_line2
	 */
	public String getCust_address_line2() {
		return cust_address_line2;
	}

	/**
	 * @param cust_address_line2 the cust_address_line2 to set
	 */
	public void setCust_address_line2(String cust_address_line2) {
		this.cust_address_line2 = cust_address_line2;
	}

	/**
	 * @return the cust_gender
	 */
	public String getCust_gender() {
		return cust_gender;
	}

	/**
	 * @param cust_gender the cust_gender to set
	 */
	public void setCust_gender(String cust_gender) {
		this.cust_gender = cust_gender;
	}

	/**
	 * @return the cust_passport_no
	 */
	public String getCust_passport_no() {
		return cust_passport_no;
	}

	/**
	 * @param cust_passport_no the cust_passport_no to set
	 */
	public void setCust_passport_no(String cust_passport_no) {
		this.cust_passport_no = cust_passport_no;
	}

	/**
	 * @return the cust_post_code
	 */
	public String getCust_post_code() {
		return cust_post_code;
	}

	/**
	 * @param cust_post_code the cust_post_code to set
	 */
	public void setCust_post_code(String cust_post_code) {
		this.cust_post_code = cust_post_code;
	}

	/**
	 * @return the cust_app_submission_date
	 */
	public Date getCust_app_submission_date() {
		return cust_app_submission_date;
	}

	/**
	 * @param cust_app_submission_date the cust_app_submission_date to set
	 */
	public void setCust_app_submission_date(Date cust_app_submission_date) {
		this.cust_app_submission_date = cust_app_submission_date;
	}

	/**
	 * @return the cust_accnt_opening_date
	 */
	public Date getCust_accnt_opening_date() {
		return cust_accnt_opening_date;
	}

	/**
	 * @param cust_accnt_opening_date the cust_accnt_opening_date to set
	 */
	public void setCust_accnt_opening_date(Date cust_accnt_opening_date) {
		this.cust_accnt_opening_date = cust_accnt_opening_date;
	}

	/**
	 * @return the cust_bank_sort_code
	 */
	public String getCust_bank_sort_code() {
		return cust_bank_sort_code;
	}

	/**
	 * @param cust_bank_sort_code the cust_bank_sort_code to set
	 */
	public void setCust_bank_sort_code(String cust_bank_sort_code) {
		this.cust_bank_sort_code = cust_bank_sort_code;
	}

	/**
	 * @return the cust_bank_branch_name
	 */
	public String getCust_bank_branch_name() {
		return cust_bank_branch_name;
	}

	/**
	 * @param cust_bank_branch_name the cust_bank_branch_name to set
	 */
	public void setCust_bank_branch_name(String cust_bank_branch_name) {
		this.cust_bank_branch_name = cust_bank_branch_name;
	}

	/**
	 * @return the cust_address_town
	 */
	public String getCust_address_town() {
		return cust_address_town;
	}

	/**
	 * @param cust_address_town the cust_address_town to set
	 */
	public void setCust_address_town(String cust_address_town) {
		this.cust_address_town = cust_address_town;
	}

	/**
	 * @return the cust_address_county
	 */
	public String getCust_address_county() {
		return cust_address_county;
	}

	/**
	 * @param cust_address_county the cust_address_county to set
	 */
	public void setCust_address_county(String cust_address_county) {
		this.cust_address_county = cust_address_county;
	}

	/**
	 * Default constructor
	 */
	public Customer() {
		
	}


	
}
