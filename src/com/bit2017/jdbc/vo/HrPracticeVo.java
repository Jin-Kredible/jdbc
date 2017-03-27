package com.bit2017.jdbc.vo;

public class HrPracticeVo {
	
	
	private int salary;
	private String firstName;
	private String lastName;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
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
		return "salary=" + salary + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
