package com.agesun.mybatis.bean;

public class Employee {
	
	private Integer id;
	private String lastName;
	private String email;
	private String gender;
	//员工状态
	private EmpsStatus empStatus=EmpsStatus.LOGINOUT;
	private String empstsus;
	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String lastName, String email, String gender) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public EmpsStatus getEmpsStatus() {
		return empStatus;
	}
	public void setEmpsStatus(EmpsStatus empsStatus) {
		this.empStatus = empsStatus;
	}

	public String getEmpstsus() {
		return empstsus;
	}

	public void setEmpstsus(String empstsus) {
		this.empstsus = empstsus;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email="
				+ email + ", gender=" + gender +", empstsus=" + empstsus+ "]";
	}
	
	

}
