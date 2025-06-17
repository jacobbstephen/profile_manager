package com.ignite2025.profileapp;

public class Profile implements Cloneable {
	private String name;
	private String employee_id;
	private String company;
	private String desigination;
	
	public void setProfile(String name, String employee_id, String company, String desigination) {
		this.name = name;
		this.employee_id = employee_id;
		this.company = company;
		this.desigination = desigination;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getDesigination() {
		return desigination;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", employee_id=" + employee_id + ", company=" + company + ", desigination="
				+ desigination + "]";
	}
	
	@Override
	public Profile clone() throws CloneNotSupportedException {
		return (Profile) super.clone();
	}

	
}
