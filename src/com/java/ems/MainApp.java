package com.java.ems;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		EmployeeOperations EmpApp = new EmployeeOperations();
		
		try {
		
			do{
				System.out.print(" \n\n1. Add Data \n2. Remove Data \n3. Search Data \n4. Update Data \n5. Display all Employee Data \n6. Hardcode Values \n0. Exit \n\nEnter your choice: ");
				choice = sc.nextInt();
				
				switch(choice){
					case 1: {   //Add Data
						EmpApp.storefromuser(sc);
						break;
			
					}
					
					case 2: {   //Remove Data
						EmpApp.removeEmployeeData(sc);
						break;
					}
					
					case 3: {	//Search Data
						EmpApp.searchEmployee(sc);
						break;
					}
					
					case 4: {   //Update Data
						EmpApp.updateEmployeeData(sc);
						break;
					}
					
					case 5: {   //Display Data
						EmpApp.displayEmployeeData();
						break;
					}
					
					case 6:{   //Hardcode Values
						EmpApp.hardcodeEmployeeData();
						break;
					}
					
					case 0: {
						System.out.println("\nThank you!");
						break;
					}
					
					default: {
						System.out.println("\nWrong Input! Please try again!");
						break;
					}
				}
			}while(choice!=0);
		}
		
		catch(InputMismatchException i) {
			System.out.println("\nInvalid input!");
		}
		catch(Exception e) {
			System.out.println("\nAn error occurred: " + e.getMessage());
		}
		
		finally {
			sc.close();
		}
}

}
