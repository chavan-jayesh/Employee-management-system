package com.java.ems;

public class SM extends Employee{
	
	private double incentive;
	private int target;
	
	public SM() {
		// TODO Auto-generated constructor stub
	}

	public SM(int id, double salary, String name, double incentive, int target) {
		super(id, salary, name);
		this.incentive = incentive;
		this.target = target;
	}

	public double getIncentive() {
		return incentive;
	}

	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String toString() {
		return "SM [incentive=" + incentive + ", target=" + target + ", id=" + super.getId() + ", salary=" + super.getSalary() + ", name="
				+ super.getName() + "]";
	}
	
	public void display() {
		super.display();
		System.out.println("Incentive: " + this.incentive + "\nTarget: " + this.target);
	}

	public double calsalary() {
		return super.getSalary() + this.incentive;
	}
	
}
