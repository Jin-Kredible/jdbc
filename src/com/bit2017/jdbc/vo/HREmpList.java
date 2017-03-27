package com.bit2017.jdbc.vo;

public class HREmpList {

	private String firstName;
	private String lastName;
	private String mFirstName;
	private String mLastName;
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
	public String getmFirstName() {
		return mFirstName;
	}
	public void setmFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}
	public String getmLastName() {
		return mLastName;
	}
	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}
	@Override
	public String toString() {
		return "HREmpList [firstName=" + firstName + ", lastName=" + lastName + ", mFirstName=" + mFirstName
				+ ", mLastName=" + mLastName + "]";
	}
	
	

	
	
	
	
}
