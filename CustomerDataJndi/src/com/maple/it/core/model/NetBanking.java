/**
 * 
 */
package com.maple.it.core.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * @author murali
 *
 */
@Entity
@Table(name="netbanking")
public class NetBanking implements Serializable{
	
	private Logger log = Logger.getLogger(NetBanking.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NetBanking() {
		super();
		log.info("Inside NetBanking()");
	}
	
	/**
	 *  constructor
	 */
	public NetBanking( Customer customer, String cust_netbanking_passwd, String cust_netbanking_pin) {
		this();
		this.customer = customer;
		this.cust_netbanking_passwd = cust_netbanking_passwd;
		this.cust_netbanking_pin = cust_netbanking_pin;
		log.info("Inside NetBanking(Customer customer)");
	}
	
	
	@Id
	@Column(name = "cust_accnt_no", unique = true, updatable = false, nullable = false)
	private int cust_accnt_no;
	
	@Column(name = "cust_netbanking_id", unique = true, nullable = false)
	private String cust_netbanking_id;
	
	@Column(name = "cust_netbanking_passwd", nullable = false)
	private String cust_netbanking_passwd;
	
	@Column(name = "cust_netbanking_pin", nullable = false)
	private String cust_netbanking_pin;

	//one-to-one association to Customer
	@OneToOne(optional=false, fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name="cust_accnt_no")
	@MapsId
	private Customer customer;
	
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
	 * @return the cust_netbanking_passwd
	 */
	public String getCust_netbanking_passwd() {
		return cust_netbanking_passwd;
	}
	/**
	 * @param cust_netbanking_passwd the cust_netbanking_passwd to set
	 */
	public void setCust_netbanking_passwd(String cust_netbanking_passwd) {
		this.cust_netbanking_passwd = cust_netbanking_passwd;
	}
	/**
	 * @return the cust_netbanking_pin
	 */
	public String getCust_netbanking_pin() {
		return cust_netbanking_pin;
	}
	
	/**
	 * @param cust_netbanking_pin the cust_netbanking_pin to set
	 */
	public void setCust_netbanking_pin(String cust_netbanking_pin) {
		this.cust_netbanking_pin = cust_netbanking_pin;
	}
	
	/*	*//**
	 * @return the customer
	 *//*
	public Customer getCustomer() {
		return customer;
	}
	
	*//**
	 * @param customer the customer to set
	 *//*
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetBanking [cust_netbanking_id=" + cust_netbanking_id
				+ ", cust_netbanking_passwd=" + cust_netbanking_passwd + ", cust_netbanking_pin=" + cust_netbanking_pin
				+ "]";
	}
	
	
}
