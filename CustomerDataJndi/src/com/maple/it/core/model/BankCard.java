/**
 * 
 */
package com.maple.it.core.model;

import java.util.Date;

/**
 * @author murali
 *
 */
public class BankCard {

	private int atm_debtcard_no;
	private int atm_debtcard_cvv;
	private int atm_debt_card_pin;
	private int cust_accnt_no;
	private String atm_debtcard_custname_oncard;
	private String atm_debtcard_grid_num;
	private String atm_debtcard_type;
	private String atm_debtcard_issue_num;
	private Date atm_debtcard_valid_from;
	private Date atm_debtcard_valid_to;
		
	/**
	 * Default constructor
	 */
	public BankCard() {
		
	}
	
	
	/**
	 * @param atm_debtcard_no
	 * @param atm_debtcard_cvv
	 * @param atm_debt_card_pin
	 * @param fk_cust_accnt_no
	 * @param atm_debtcard_custname_oncard
	 * @param atm_debtcard_grid_num
	 * @param atm_debtcard_type
	 * @param atm_debtcard_issue_num
	 * @param atm_debtcard_valid_from
	 * @param atm_debtcard_valid_to
	 */
	public BankCard(int atm_debtcard_no, int atm_debtcard_cvv, int atm_debt_card_pin, int fk_cust_accnt_no,
			String atm_debtcard_custname_oncard, String atm_debtcard_grid_num, String atm_debtcard_type,
			String atm_debtcard_issue_num, Date atm_debtcard_valid_from, Date atm_debtcard_valid_to) {
		super();
		this.atm_debtcard_no = atm_debtcard_no;
		this.atm_debtcard_cvv = atm_debtcard_cvv;
		this.atm_debt_card_pin = atm_debt_card_pin;
		this.cust_accnt_no = fk_cust_accnt_no;
		this.atm_debtcard_custname_oncard = atm_debtcard_custname_oncard;
		this.atm_debtcard_grid_num = atm_debtcard_grid_num;
		this.atm_debtcard_type = atm_debtcard_type;
		this.atm_debtcard_issue_num = atm_debtcard_issue_num;
		this.atm_debtcard_valid_from = atm_debtcard_valid_from;
		this.atm_debtcard_valid_to = atm_debtcard_valid_to;
	}


	/**
	 * @param atm_debtcard_no the atm_debtcard_no to set
	 */
	public void setAtm_debtcard_no(int atm_debtcard_no) {
		this.atm_debtcard_no = atm_debtcard_no;
	}



	/**
	 * @param atm_debtcard_cvv the atm_debtcard_cvv to set
	 */
	public void setAtm_debtcard_cvv(int atm_debtcard_cvv) {
		this.atm_debtcard_cvv = atm_debtcard_cvv;
	}



	/**
	 * @param atm_debt_card_pin the atm_debt_card_pin to set
	 */
	public void setAtm_debt_card_pin(int atm_debt_card_pin) {
		this.atm_debt_card_pin = atm_debt_card_pin;
	}



	/**
	 * @param fk_cust_accnt_no the fk_cust_accnt_no to set
	 */
	public void setFk_cust_accnt_no(int fk_cust_accnt_no) {
		this.cust_accnt_no = fk_cust_accnt_no;
	}



	/**
	 * @param atm_debtcard_custname_oncard the atm_debtcard_custname_oncard to set
	 */
	public void setAtm_debtcard_custname_oncard(String atm_debtcard_custname_oncard) {
		this.atm_debtcard_custname_oncard = atm_debtcard_custname_oncard;
	}



	/**
	 * @param atm_debtcard_grid_num the atm_debtcard_grid_num to set
	 */
	public void setAtm_debtcard_grid_num(String atm_debtcard_grid_num) {
		this.atm_debtcard_grid_num = atm_debtcard_grid_num;
	}



	/**
	 * @param atm_debtcard_type the atm_debtcard_type to set
	 */
	public void setAtm_debtcard_type(String atm_debtcard_type) {
		this.atm_debtcard_type = atm_debtcard_type;
	}



	/**
	 * @param atm_debtcard_issue_num the atm_debtcard_issue_num to set
	 */
	public void setAtm_debtcard_issue_num(String atm_debtcard_issue_num) {
		this.atm_debtcard_issue_num = atm_debtcard_issue_num;
	}



	/**
	 * @param atm_debtcard_valid_from the atm_debtcard_valid_from to set
	 */
	public void setAtm_debtcard_valid_from(Date atm_debtcard_valid_from) {
		this.atm_debtcard_valid_from = atm_debtcard_valid_from;
	}



	/**
	 * @param atm_debtcard_valid_to the atm_debtcard_valid_to to set
	 */
	public void setAtm_debtcard_valid_to(Date atm_debtcard_valid_to) {
		this.atm_debtcard_valid_to = atm_debtcard_valid_to;
	}

	

	/**
	 * @return the atm_debtcard_no
	 */
	public int getAtm_debtcard_no() {
		return atm_debtcard_no;
	}

	/**
	 * @return the atm_debtcard_cvv
	 */
	public int getAtm_debtcard_cvv() {
		return atm_debtcard_cvv;
	}

	/**
	 * @return the atm_debt_card_pin
	 */
	public int getAtm_debt_card_pin() {
		return atm_debt_card_pin;
	}

	/**
	 * @return the fk_cust_accnt_no
	 */
	public int getFk_cust_accnt_no() {
		return cust_accnt_no;
	}

	/**
	 * @return the atm_debtcard_custname_oncard
	 */
	public String getAtm_debtcard_custname_oncard() {
		return atm_debtcard_custname_oncard;
	}

	/**
	 * @return the atm_debtcard_grid_num
	 */
	public String getAtm_debtcard_grid_num() {
		return atm_debtcard_grid_num;
	}

	/**
	 * @return the atm_debtcard_type
	 */
	public String getAtm_debtcard_type() {
		return atm_debtcard_type;
	}

	/**
	 * @return the atm_debtcard_issue_num
	 */
	public String getAtm_debtcard_issue_num() {
		return atm_debtcard_issue_num;
	}

	/**
	 * @return the atm_debtcard_valid_from
	 */
	public Date getAtm_debtcard_valid_from() {
		return atm_debtcard_valid_from;
	}

	/**
	 * @return the atm_debtcard_valid_to
	 */
	public Date getAtm_debtcard_valid_to() {
		return atm_debtcard_valid_to;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bankcard [atm_debt_card_pin=" + atm_debt_card_pin + ", atm_debtcard_custname_oncard="
				+ atm_debtcard_custname_oncard + ", atm_debtcard_cvv=" + atm_debtcard_cvv + ", atm_debtcard_grid_num="
				+ atm_debtcard_grid_num + ", atm_debtcard_issue_num=" + atm_debtcard_issue_num + ", atm_debtcard_no="
				+ atm_debtcard_no + ", atm_debtcard_type=" + atm_debtcard_type + ", atm_debtcard_valid_from="
				+ atm_debtcard_valid_from + ", atm_debtcard_valid_to=" + atm_debtcard_valid_to + ", fk_cust_accnt_no="
				+ cust_accnt_no + ", toString()=" + super.toString() + "]";
	}

}
