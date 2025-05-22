package com.java.ems;

public class Admin extends Employee{
	
	private double allowance;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int id, double salary, String name, double allowance) {
		super(id, salary, name);
		this.allowance = allowance;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public String toString() {
		return "Admin [allowance=" + allowance + ", id=" + super.getId() + ", salary=" + super.getSalary() + ", name=" + super.getName() + "]";
	}

	public void display() {
		super.display();
		System.out.println("Allowance: " + this.allowance);
	}

	public double calsalary() {
		return super.getSalary() + this.allowance;
	}
	

}
