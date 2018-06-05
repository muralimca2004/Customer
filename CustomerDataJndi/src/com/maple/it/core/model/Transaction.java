/**
 * 
 */
package com.maple.it.core.model;

import java.util.Date;

/**
 * @author murali
 *
 */
public class Transaction {
	
	private int txn_id;
	private Date txn_time_stamp;
	private float txn_amount;
	private int cust_accnt_no;
	private float opening_balance;
	private float closing_balance;
	private String txn_description;
	private String txn_status;

	/**
	 * Default Constructor
	 */
	public Transaction() {
		
	}

	/**
	 * @return the txn_id
	 */
	public int getTxn_id() {
		return txn_id;
	}

	/**
	 * @param txn_id the txn_id to set
	 */
	public void setTxn_id(int txn_id) {
		this.txn_id = txn_id;
	}

	/**
	 * @return the txn_time_stamp
	 */
	public Date getTxn_time_stamp() {
		return txn_time_stamp;
	}

	/**
	 * @param txn_time_stamp the txn_time_stamp to set
	 */
	public void setTxn_time_stamp(Date txn_time_stamp) {
		this.txn_time_stamp = txn_time_stamp;
	}

	/**
	 * @return the txn_amount
	 */
	public float getTxn_amount() {
		return txn_amount;
	}

	/**
	 * @param txn_amount the txn_amount to set
	 */
	public void setTxn_amount(float txn_amount) {
		this.txn_amount = txn_amount;
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
	 * @return the opening_balance
	 */
	public float getOpening_balance() {
		return opening_balance;
	}

	/**
	 * @param opening_balance the opening_balance to set
	 */
	public void setOpening_balance(float opening_balance) {
		this.opening_balance = opening_balance;
	}

	/**
	 * @return the closing_balance
	 */
	public float getClosing_balance() {
		return closing_balance;
	}

	/**
	 * @param closing_balance the closing_balance to set
	 */
	public void setClosing_balance(float closing_balance) {
		this.closing_balance = closing_balance;
	}

	/**
	 * @return the txn_description
	 */
	public String getTxn_description() {
		return txn_description;
	}

	/**
	 * @param txn_description the txn_description to set
	 */
	public void setTxn_description(String txn_description) {
		this.txn_description = txn_description;
	}

	/**
	 * @return the txn_status
	 */
	public String getTxn_status() {
		return txn_status;
	}

	/**
	 * @param txn_status the txn_status to set
	 */
	public void setTxn_status(String txn_status) {
		this.txn_status = txn_status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [txn_id=" + txn_id + ", txn_time_stamp=" + txn_time_stamp + ", txn_amount=" + txn_amount
				+ ", cust_accnt_no=" + cust_accnt_no + ", opening_balance=" + opening_balance + ", closing_balance="
				+ closing_balance + ", txn_description=" + txn_description + ", txn_status=" + txn_status + "]";
	}

	
}
