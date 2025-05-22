package com.java.ems;

public class HR extends Employee{
	
	private double commission;
	
	public HR() {
		// TODO Auto-generated constructor stub
	}

	public HR(int id, double salary, String name, double commission) {
		super(id, salary, name);
		
		this.commission = commission;
		// TODO Auto-generated constructor stub
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
	public String toString() {
		return "HR [commission=" + commission + ", id=" + super.getId() + ", salary=" + super.getSalary() + ", name=" + super.getName() + "]";
	}
	
	public void display() {
		super.display();
		System.out.println("Commission: " + this.commission);
	}

	public double calsalary() {
		return super.getSalary() + this.commission;
	}
	
}
