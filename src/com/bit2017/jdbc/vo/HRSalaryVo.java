package com.bit2017.jdbc.vo;

public class HRSalaryVo {
	int Salary;
	String firstName;
	String lastName;
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "HRSalaryVo [Salary=" + Salary + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

	
}
