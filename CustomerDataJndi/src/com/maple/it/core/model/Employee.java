package com.maple.it.core.model;

public class Employee {
	
	private int emp_no;
	private String emp_name;
	private String branch_name;
	private String emp_last_name;
	private String emp_first_name;
	private String emp_email;
	private String emp_phone_no;	
	private String emp_gender;
	private String emp_passport_no;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the emp_no
	 */
	public int getEmp_no() {
		return emp_no;
	}

	/**
	 * @param emp_no the emp_no to set
	 */
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	/**
	 * @return the emp_name
	 */
	public String getEmp_name() {
		return emp_name;
	}

	/**
	 * @param emp_name the emp_name to set
	 */
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	/**
	 * @return the branch_name
	 */
	public String getBranch_name() {
		return branch_name;
	}

	/**
	 * @param branch_name the branch_name to set
	 */
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	/**
	 * @return the emp_last_name
	 */
	public String getEmp_last_name() {
		return emp_last_name;
	}

	/**
	 * @param emp_last_name the emp_last_name to set
	 */
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}

	/**
	 * @return the emp_first_name
	 */
	public String getEmp_first_name() {
		return emp_first_name;
	}

	/**
	 * @param emp_first_name the emp_first_name to set
	 */
	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}

	/**
	 * @return the emp_email
	 */
	public String getEmp_email() {
		return emp_email;
	}

	/**
	 * @param emp_email the emp_email to set
	 */
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	/**
	 * @return the emp_phone_no
	 */
	public String getEmp_phone_no() {
		return emp_phone_no;
	}

	/**
	 * @param emp_phone_no the emp_phone_no to set
	 */
	public void setEmp_phone_no(String emp_phone_no) {
		this.emp_phone_no = emp_phone_no;
	}

	/**
	 * @return the emp_gender
	 */
	public String getEmp_gender() {
		return emp_gender;
	}

	/**
	 * @param emp_gender the emp_gender to set
	 */
	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	/**
	 * @return the emp_passport_no
	 */
	public String getEmp_passport_no() {
		return emp_passport_no;
	}

	/**
	 * @param emp_passport_no the emp_passport_no to set
	 */
	public void setEmp_passport_no(String emp_passport_no) {
		this.emp_passport_no = emp_passport_no;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [emp_no=" + emp_no + ", emp_name=" + emp_name + ", branch_name=" + branch_name
				+ ", emp_last_name=" + emp_last_name + ", emp_first_name=" + emp_first_name + ", emp_email=" + emp_email
				+ ", emp_phone_no=" + emp_phone_no + ", emp_gender=" + emp_gender + ", emp_passport_no=" + emp_passport_no
				+ "]";
	}
	
	
}
