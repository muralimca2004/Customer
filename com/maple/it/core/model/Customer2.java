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
public class Customer2 {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int custAccntNo;  
	//cust_bank_accnt_no ??
	
	/*private int cust_age;
	
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
*/	

	
	
	
	private int custAge;
	private String custAccntType;
	private String custLastName;
	private String custFirstName;
	private String custAddressLine1;
	private String custAddressLine2;	
	private String custGender;
	private String custPassportNo;
	private String custPostCode;
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date custAppSubmissionDate;	
	private Date custAccntOpeningDate;
	private String custBankSortCode;
	private String custBankBranchName;
	private String custAddressTown;
	private String custAddressCounty;

	
	/**
	 * Default constructor
	 */
	public Customer2() {
		
	}


	/**
	 * @return the custAge
	 */
	public int getCustAge() {
		return custAge;
	}


	/**
	 * @param custAge the custAge to set
	 */
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}


	/**
	 * @return the custAccntNo
	 */
	public int getCustAccntNo() {
		return custAccntNo;
	}


	/**
	 * @param custAccntNo the custAccntNo to set
	 */
	public void setCustAccntNo(int custAccntNo) {
		this.custAccntNo = custAccntNo;
	}


	/**
	 * @return the custAccntType
	 */
	public String getCustAccntType() {
		return custAccntType;
	}


	/**
	 * @param custAccntType the custAccntType to set
	 */
	public void setCustAccntType(String custAccntType) {
		this.custAccntType = custAccntType;
	}


	/**
	 * @return the custLastName
	 */
	public String getCustLastName() {
		return custLastName;
	}


	/**
	 * @param custLastName the custLastName to set
	 */
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}


	/**
	 * @return the custFirstName
	 */
	public String getCustFirstName() {
		return custFirstName;
	}


	/**
	 * @param custFirstName the custFirstName to set
	 */
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}


	/**
	 * @return the custAddressLine1
	 */
	public String getCustAddressLine1() {
		return custAddressLine1;
	}


	/**
	 * @param custAddressLine1 the custAddressLine1 to set
	 */
	public void setCustAddressLine1(String custAddressLine1) {
		this.custAddressLine1 = custAddressLine1;
	}


	/**
	 * @return the custAddressLine2
	 */
	public String getCustAddressLine2() {
		return custAddressLine2;
	}


	/**
	 * @param custAddressLine2 the custAddressLine2 to set
	 */
	public void setCustAddressLine2(String custAddressLine2) {
		this.custAddressLine2 = custAddressLine2;
	}


	/**
	 * @return the custGender
	 */
	public String getCustGender() {
		return custGender;
	}


	/**
	 * @param custGender the custGender to set
	 */
	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}


	/**
	 * @return the custPassportNo
	 */
	public String getCustPassportNo() {
		return custPassportNo;
	}


	/**
	 * @param custPassportNo the custPassportNo to set
	 */
	public void setCustPassportNo(String custPassportNo) {
		this.custPassportNo = custPassportNo;
	}


	/**
	 * @return the custPostCode
	 */
	public String getCustPostCode() {
		return custPostCode;
	}


	/**
	 * @param custPostCode the custPostCode to set
	 */
	public void setCustPostCode(String custPostCode) {
		this.custPostCode = custPostCode;
	}


	/**
	 * @return the custAppSubmissionDate
	 */
	public Date getCustAppSubmissionDate() {
		return custAppSubmissionDate;
	}


	/**
	 * @param custAppSubmissionDate the custAppSubmissionDate to set
	 */
	public void setCustAppSubmissionDate(Date custAppSubmissionDate) {
		this.custAppSubmissionDate = custAppSubmissionDate;
	}


	/**
	 * @return the custAccntOpeningDate
	 */
	public Date getCustAccntOpeningDate() {
		return custAccntOpeningDate;
	}


	/**
	 * @param custAccntOpeningDate the custAccntOpeningDate to set
	 */
	public void setCustAccntOpeningDate(Date custAccntOpeningDate) {
		this.custAccntOpeningDate = custAccntOpeningDate;
	}


	/**
	 * @return the custBankSortCode
	 */
	public String getCustBankSortCode() {
		return custBankSortCode;
	}


	/**
	 * @param custBankSortCode the custBankSortCode to set
	 */
	public void setCustBankSortCode(String custBankSortCode) {
		this.custBankSortCode = custBankSortCode;
	}


	/**
	 * @return the custBankBranchName
	 */
	public String getCustBankBranchName() {
		return custBankBranchName;
	}


	/**
	 * @param custBankBranchName the custBankBranchName to set
	 */
	public void setCustBankBranchName(String custBankBranchName) {
		this.custBankBranchName = custBankBranchName;
	}


	/**
	 * @return the custAddressTown
	 */
	public String getCustAddressTown() {
		return custAddressTown;
	}


	/**
	 * @param custAddressTown the custAddressTown to set
	 */
	public void setCustAddressTown(String custAddressTown) {
		this.custAddressTown = custAddressTown;
	}


	/**
	 * @return the custAddressCounty
	 */
	public String getCustAddressCounty() {
		return custAddressCounty;
	}


	/**
	 * @param custAddressCounty the custAddressCounty to set
	 */
	public void setCustAddressCounty(String custAddressCounty) {
		this.custAddressCounty = custAddressCounty;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [custAge=" + custAge + ", custAccntNo=" + custAccntNo + ", custAccntType=" + custAccntType
				+ ", custLastName=" + custLastName + ", custFirstName=" + custFirstName + ", custAddressLine1="
				+ custAddressLine1 + ", custAddressLine2=" + custAddressLine2 + ", custGender=" + custGender
				+ ", custPassportNo=" + custPassportNo + ", custPostCode=" + custPostCode + ", custAppSubmissionDate="
				+ custAppSubmissionDate + ", custAccntOpeningDate=" + custAccntOpeningDate + ", custBankSortCode="
				+ custBankSortCode + ", custBankBranchName=" + custBankBranchName + ", custAddressTown="
				+ custAddressTown + ", custAddressCounty=" + custAddressCounty + "]";
	}

	
}
