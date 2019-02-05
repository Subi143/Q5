package com.cg.eis.service.Q5_b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.cg.eis.bean.Q5_a.Employee;
import com.cg.eis.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	HashMap<Integer, Employee> employees = new HashMap<>();
	EmployeeService employeeService;

	@Override
	public void getEmployeeDetails() {
		Set s = employees.entrySet();
		Iterator iterator = s.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().toString());
		}

	}

	@Override
	public String getInsurenceDetails(Employee e) {
		if ((e.getSalary() > 5000 && e.getSalary() < 20000)
				|| e.getDesignation().equalsIgnoreCase("system associate")) {
			return "Scheme C";
		} else if ((e.getSalary() >= 20000 && e.getSalary() < 40000)
				|| e.getDesignation().equalsIgnoreCase("programmer")) {
			return "Scheme B";
		} else if (e.getSalary() >= 40000 || e.getDesignation().equals("manager")) {
			return "Scheme A";
		} else if (e.getSalary() < 5000 || e.getDesignation().equals("clerk")) {
			return "No Scheme";
		} else {
			System.out.println("invalid");
			return null;
		}

	}

	@Override
	public void addEmployee() throws EmployeeException {
		int n = 0;
		do {
			System.out.println("Enter Employee Detais \n------------------------------");
			Scanner scanner = new Scanner(System.in);
			System.out.print("\nEnter employee id: ");
			int id = scanner.nextInt();
			System.out.print("\nEnter Employee Name: ");
			String name = scanner.next();
			System.out.print("\nEnter Employee Salary: ");
			double salary = scanner.nextDouble();
			if(salary < 3000)
				throw new EmployeeException("Low Salary.....Poor Fella");
			System.out.println("\nEnter Employee Designation: ");
			String designation = scanner.next();
			Employee employee = new Employee(id, name, salary, designation);
			employeeService = getEmployeeService();
			employee.setInsuranceScheme(employeeService.getInsurenceDetails(employee));
			System.out.print("\nInsurence Scheme is " + employee.getInsuranceScheme());
			employees.put(id, employee);
			System.out.println("\nDo You Want To Continue ------> (1/0)");
			n = scanner.nextInt();
		} while (n != 0);

	}

	private EmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}

	@Override
	public void deleteEmployee(int id) {
		
		employees.remove(id);

	}
}
