/**
 * 
 */
package com.maple.it.core.model;

/**
 * @author murali
 *
 */
public class Payment {
	
	private int payment_id;
	private int payment_no;
	private int cust_accnt_no;

	/**
	 * Default Constructor
	 */
	public Payment() {
		
	}
	
	
	/**
	 * @param payment_id
	 * @param payment_no
	 * @param cust_accnt_no
	 */
	public Payment(int payment_id, int payment_no, int cust_accnt_no) {
		super();
		this.payment_id = payment_id;
		this.payment_no = payment_no;
		this.cust_accnt_no = cust_accnt_no;
	}



	/**
	 * @param payment_id the payment_id to set
	 */
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	/**
	 * @param payment_no the payment_no to set
	 */
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}

	/**
	 * @param cust_accnt_no the cust_accnt_no to set
	 */
	public void setCust_accnt_no(int cust_accnt_no) {
		this.cust_accnt_no = cust_accnt_no;
	}

	/**
	 * @return the payment_id
	 */
	public int getPayment_id() {
		return payment_id;
	}

	/**
	 * @return the payment_no
	 */
	public int getPayment_no() {
		return payment_no;
	}

	/**
	 * @return the cust_accnt_no
	 */
	public int getCust_accnt_no() {
		return cust_accnt_no;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_no=" + payment_no + ", cust_accnt_no=" + cust_accnt_no
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
