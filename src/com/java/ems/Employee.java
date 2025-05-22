package com.java.ems;

public abstract class Employee {
		
	private int id;
	private double salary;
	private String name;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, double salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract String toString();

	public void display() {
		System.out.println("\nID: " + this.id + "\nName: " + this.name + "\nSalary: " + this.salary);
	}
	
	public abstract double calsalary();

}
