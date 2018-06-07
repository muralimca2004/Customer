/**
 * 
 */
package com.maple.it.core.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author murali
 *
 */

@Entity
@Table(name="customer")
public class Customer {
	
	public static Customer newInstance(Customer customer, String cust_netbanking_passwd, String cust_netbanking_pin) {
		
		customer.netbanking = new NetBanking(customer, cust_netbanking_passwd, cust_netbanking_pin);
		return customer;
	}
	
	public Customer(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cust_accnt_no", unique = true, updatable = false, nullable = false)
	private int cust_accnt_no;
	
	//one-to-one association to NetBanking
	@OneToOne(mappedBy="customer", cascade=CascadeType.PERSIST)
	private NetBanking netbanking;
	
	@Column(name = "cust_netbanking_id", unique = true, nullable = false)
	@NotEmpty(message="Netbanking Id can not left blank")
	@Size(min=9, max=12, message="Netbanking Id should be of length 9-12")
	private String cust_netbanking_id;
	
	//enableNetBanking? yes/no
	//checkbox
	private boolean cust_enable_netbanking = true; //checked it

	private String cust_accnt_type;
	
	@NotEmpty(message="LastName can not left blank")
	@Pattern(regexp = "[a-z-A-Z]*", message = "LastName has invalid characters")
	private String cust_last_name;
	
	@NotEmpty(message="FirstName can't left blank")
	@Pattern(regexp = "[a-z-A-Z]*", message = "FirstName has invalid characters")
	private String cust_first_name;
	
	@NotEmpty(message="Address can't left blank")
	private String cust_address_line1;
	private String cust_address_line2;
	
	@NotEmpty(message="Gender can not left blank")
	private String cust_gender;
	
	@Column(name = "cust_passport_no", unique = true, nullable = false)
	@NotEmpty(message="PassportNo can't left blank")
	private String cust_passport_no;
	
	@NotEmpty(message="PostCode can't left blank")
	private String cust_post_code;
	
	@NotEmpty(message="PhoneNo can't left blank")
	private String cust_phone_no;
	
	@NotEmpty(message="Email can't left blank")
	private String cust_email;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date cust_app_submission_date;	
	private Date cust_accnt_opening_date;
	private String cust_bank_sort_code;
	
	@NotEmpty(message="Please select NearBy branch")
	private String cust_bank_branch_name;
	
	@NotNull(message="DateOfBirth is required!")
    @Past(message = "Date of Birth must be the past")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date cust_dateofbirth;
	
	@NotEmpty(message="Town can't left blank")
	private String cust_address_town;
	
	@NotEmpty(message="County can't left blank")
	private String cust_address_county;

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
	 * @return the cust_phone_no
	 */
	public String getCust_phone_no() {
		return cust_phone_no;
	}

	/**
	 * @param cust_phone_no the cust_phone_no to set
	 */
	public void setCust_phone_no(String cust_phone_no) {
		this.cust_phone_no = cust_phone_no;
	}

	/**
	 * @return the cust_email
	 */
	@NotNull(message="Email Address is compulsory")
    @NotBlank(message="Email Address is compulsory")
    @Email(message = "Email Address is not a valid format")
	public String getCust_email() {
		return cust_email;
	}

	/**
	 * @param cust_email the cust_email to set
	 */
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
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
	 * @return the cust_dateofbirth
	 */
	public Date getCust_dateofbirth() {
		return cust_dateofbirth;
	}

	/**
	 * @param cust_dateofbirth the cust_dateofbirth to set
	 */
	public void setCust_dateofbirth(Date cust_dateofbirth) {
		this.cust_dateofbirth = cust_dateofbirth;
	}
	
	/**
	 * @return the cust_netbanking_id
	 */
	public String getCust_netbanking_id() {
		return cust_netbanking_id;
	}

	/**
	 * @param cust_netbanking_id the cust_netbanking_id to set
	 */
	public void setCust_netbanking_id(String cust_netbanking_id) {
		this.cust_netbanking_id = cust_netbanking_id;
	}

	/**
	 * @return the cust_enable_netbanking
	 */
	public boolean isCust_enable_netbanking() {
		return cust_enable_netbanking;
	}

	/**
	 * @param cust_enable_netbanking the cust_enable_netbanking to set
	 */
	public void setCust_enable_netbanking(boolean cust_enable_netbanking) {
		this.cust_enable_netbanking = cust_enable_netbanking;
	}

	/*	*//**
	 * @return the netbanking
	 *//*
	public NetBanking getNetbanking() {
		return netbanking;
	}

	*//**
	 * @param netbanking the netbanking to set
	 *//*
	public void setNetbanking(NetBanking netbanking) {
		this.netbanking = netbanking;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [cust_accnt_no=" + cust_accnt_no + ", netbanking=" + netbanking + ", cust_netbanking_id="
				+ cust_netbanking_id + ", cust_enable_netbanking=" + cust_enable_netbanking + ", cust_accnt_type="
				+ cust_accnt_type + ", cust_last_name=" + cust_last_name + ", cust_first_name=" + cust_first_name
				+ ", cust_address_line1=" + cust_address_line1 + ", cust_address_line2=" + cust_address_line2
				+ ", cust_gender=" + cust_gender + ", cust_passport_no=" + cust_passport_no + ", cust_post_code="
				+ cust_post_code + ", cust_phone_no=" + cust_phone_no + ", cust_email=" + cust_email
				+ ", cust_app_submission_date=" + cust_app_submission_date + ", cust_accnt_opening_date="
				+ cust_accnt_opening_date + ", cust_bank_sort_code=" + cust_bank_sort_code + ", cust_bank_branch_name="
				+ cust_bank_branch_name + ", cust_dateofbirth=" + cust_dateofbirth + ", cust_address_town="
				+ cust_address_town + ", cust_address_county=" + cust_address_county + "]";
	}
	
	
}