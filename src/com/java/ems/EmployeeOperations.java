package com.java.ems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeOperations{
	
	private List<Employee> EmpList = new ArrayList<>();
	
	public void storefromuser(Scanner sc){
		
		System.out.print("\nSelect which type of employee you want to add \n\n1. Sales Manager \n2. Admin \n3. HR \n\nEnter your choice: ");
		int ch = sc.nextInt();
		
		if(ch==1){
			String ename;
			int eid, etarget;
			double esalary, eincentive;
			
			System.out.print("\nEnter Employee ID: ");
			eid = sc.nextInt();
			
			System.out.print("\nEnter Employee name: ");
			sc.nextLine(); 
			ename = sc.nextLine();
			
			System.out.print("\nEnter Employee Salary: ");
			esalary = sc.nextDouble();
			
			System.out.print("\nEnter Employee Incentive: ");
			eincentive = sc.nextDouble();;
			
			System.out.print("\nEnter Target: ");
			etarget = sc.nextInt();
			
			EmpList.add(new SM(eid, esalary, ename, eincentive, etarget));
			
			System.out.println("\nEmployee Added Successfully!");

		}
		else if(ch==2){
			String ename;
			int eid;
			double esalary, eallowance;
			
			System.out.print("\nEnter Employee ID: ");
			eid = sc.nextInt();
			
			System.out.print("\nEnter Employee name: ");
			sc.nextLine(); 
			ename = sc.nextLine();
			
			System.out.print("\nEnter Employee Salary: ");
			esalary = sc.nextDouble();
			
			System.out.print("\nEnter Employee Allowance: ");
			eallowance = sc.nextDouble();;
			
			EmpList.add(new Admin(eid, esalary, ename, eallowance));
			
			System.out.println("\nEmployee Added Successfully!");
		}
		else if(ch==3){
			String ename;
			int eid;
			double esalary, ecommission;
			
			System.out.print("\nEnter Employee ID: ");
			eid = sc.nextInt();
			
			System.out.print("\nEnter Employee name: ");
			sc.nextLine(); 
			ename = sc.nextLine();
			
			System.out.print("\nEnter Employee Salary: ");
			esalary = sc.nextDouble();
			
			System.out.print("\nEnter Employee Commission: ");
			ecommission = sc.nextDouble();;
			
			EmpList.add(new HR(eid, esalary, ename, ecommission));
			
			System.out.println("\nEmployee Added Successfully!");
		}
		else{
			System.out.println("\nWrong Choice Input!!");
		}
			
	}

	public void removeEmployeeData(Scanner sc){
		if(EmpList.isEmpty()){
			System.out.println("\nNo Employee Present!");
		}
		else{
			int eId; 
			System.out.print("\nEnter Employee ID to search: ");
			eId = sc.nextInt();
			int rmvindex = this.searchById(eId);
			if(rmvindex!=-1){
				EmpList.remove(rmvindex);
				System.out.println("\nEmployee Deleted Successfully!");
			}
		}
	}

	public void searchEmployee(Scanner sc) {
		if(EmpList.isEmpty()){
			System.out.println("\nNo Employee Present!");
		}
		else{
			int ch, eindex;
			System.out.print("\n1. Search by ID \n2. Search by Name \n\nEnter your choice: ");
			ch = sc.nextInt();
			
			if(ch==1){
				int eId;
				System.out.print("\nEnter Employee ID: ");
				eId = sc.nextInt();
				eindex = this.searchById(eId);
				if(eindex!=-1){
					System.out.println("\nEmployee Found at index "+ eindex + "!");
					EmpList.get(eindex).display();
				}
				
			}
			else if(ch==2){
				String ename;
				System.out.print("\nEnter Employee name: ");
				sc.nextLine();
				ename = sc.nextLine();
				eindex = this.searchByName(ename);
				if(eindex!=-1){
					System.out.println("\nEmployee Found at index "+ eindex + "!");
					EmpList.get(eindex).display();
				}
				
			}
			else{
				System.out.println("\nWrong Choice Input!");
			}
		}
	}

	public int searchByName(String ename) {
		if(EmpList.isEmpty()){
			System.out.println("\nNo Employee Present!");
			return -1;
		}
		else{
			for(int i = 0; i < EmpList.size(); i++){
				if(EmpList.get(i).getName().equals(ename)){
					return i;
				}
			}
			System.out.println("\nEmployee not Found!");
			return -1;
		}	
		
	}

	public int searchById(int eId) {
		if(EmpList.isEmpty()){
			System.out.println("\nNo Employee Present!");
			return -1;
		}
		else{
			for(int i = 0; i<EmpList.size(); i++){
				if(EmpList.get(i).getId()==eId){
					return i;
				}
			}
			System.out.println("\nEmployee not Found!");
			return -1;
		}
		
	}

	public void displayEmployeeData() {
		if(EmpList.isEmpty()){
			System.out.println("\nNo Employee Present!");
		}
		else{
			for(int i = 0; i < EmpList.size(); i++){
				EmpList.get(i).display();
			}
		}
	}

	public void updateEmployeeData(Scanner sc) {
		if(EmpList.isEmpty()){
			System.out.println("\nNo Employee Present!");
		}
		else{
			int eId, eindex;
			System.out.print("\nEnter Employee ID you want to update: ");
			eId = sc.nextInt();
			eindex = this.searchById(eId);
			if(eindex!=-1){
				System.out.print("\nEmployee Found at index " + eindex + "!");
				EmpList.get(eindex).display();
				this.updateEmp(eindex, sc);
			}
		}
	}
	
	public void updateEmp(int eindex, Scanner sc) {
		int ch, num = 0;
	    
		System.out.print("\n\nWhat do you want to update \n\n1. ID \n2. Name \n3. Salary");
		if (EmpList.get(eindex) instanceof HR) {
			System.out.println("\n4. Commission");
		    num = 1;
		}
		else if (EmpList.get(eindex) instanceof Admin) {
			System.out.println("\n4. Allowance");
		    num = 2;
		}
		else if (EmpList.get(eindex) instanceof SM) {
			System.out.println("\n4. Incentive \n5. Target");
		    num = 3;
		}
		
		System.out.print("\nEnter your choice: ");
		ch = sc.nextInt();
		switch(ch){
			case 1:{
				int uId;
				System.out.print("\nEnter ID: ");
				uId = sc.nextInt();
				EmpList.get(eindex).setId(uId);
				System.out.print("\nEmployee ID updated successfully!");
				break;
			}
			
			case 2:{
				String uname;
				System.out.print("\nEnter new Employee name: ");
				sc.nextLine();
				uname = sc.nextLine();
				EmpList.get(eindex).setName(uname);
				System.out.print("\nEmployee Name updated successfully!");
				break;
			}
			
			case 3:{
				double usalary;
				System.out.print("\nEnter new Salary: ");
				usalary = sc.nextDouble();
				EmpList.get(eindex).setSalary(usalary);
				System.out.print("\nEmployee Salary updated successfully!");
				break;
			}
			
			case 4:{
				if(num==1){
					double ucommission;
					System.out.print("\nEnter new Commission: ");
					ucommission = sc.nextDouble();
					HR hrobj = (HR) EmpList.get(eindex);
					hrobj.setCommission(ucommission);
					System.out.print("\nHR Commission updated successfully!");
				}
				else if(num==2){
					double uallowance;
					System.out.print("\nEnter new Allowance: ");
					uallowance = sc.nextDouble();
					Admin adminobj = (Admin) EmpList.get(eindex);
					adminobj.setAllowance(uallowance);
					System.out.print("\nAdmin Allowance updated successfully!");
				}
				else if(num==3){
					double uincentive;
					System.out.print("\nEnter new Incentive: ");
					uincentive = sc.nextDouble();
					SM smobj = (SM) EmpList.get(eindex);
					smobj.setIncentive(uincentive);
					System.out.print("\nSales Manager Incentive updated successfully!");
				}
				break;
			}
			
			case 5:{
				if(EmpList.get(eindex) instanceof SM){
					int utarget;
					System.out.print("\nEnter new Target: ");
					utarget = sc.nextInt();
					SM smobj = (SM) EmpList.get(eindex);
					smobj.setTarget(utarget);
					System.out.print("\nSales Manager Target updated successfully!");
				}
				else{
					System.out.println("\nWrong Input!");
				}
				
				break;
			}
			
			default:{
				System.out.println("\nWrong Input!");
				break;
			}
		}
	}

	public void hardcodeEmployeeData() {
		EmpList.add(new SM(101, 120000, "Nakul",  10000, 150));
		EmpList.add(new Admin(102, 35000, "Shashi", 2000));
		EmpList.add(new HR(103, 65000, "Manish", 5000));
		EmpList.add(new Admin(104, 30000, "Sakshi", 1500));
		EmpList.add(new SM(105, 100000, "Nilesh",  15000, 170));
		
		System.out.println("\nEmployees added Successfully!");
	}
	
}
