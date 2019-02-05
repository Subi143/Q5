package com.cg.eis.pl.Q5_c;

import java.util.Scanner;

import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.Q5_b.EmployeeService;
import com.cg.eis.service.Q5_b.EmployeeServiceImpl;

public class EmployeeMainRunner {

	public static void main(String[] args) {
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		try {
			employeeService.addEmployee();
		} catch (EmployeeException e) {
			System.out.print("\n"+e.getMessage());
			System.exit(0);
		}
		employeeService.getEmployeeDetails();
		System.out.println("Enter the id to remove employee");
		Scanner scanner = new Scanner(System.in);
		int  id = scanner.nextInt();
		employeeService.deleteEmployee(id);
		employeeService.getEmployeeDetails();

	}

}
