package com.flexnet.reimbursement.model;

public class TestModel {
	
	String name;
	
	String lastName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "TestModel [name=" + name + ", lastName=" + lastName + "]";
	}
	
	

}
