package com.cg.eis.service.Q5_b;

import com.cg.eis.bean.Q5_a.Employee;

public interface EmployeeService {
	
		void getEmployeeDetails();
		String getInsurenceDetails(Employee e);
		void addEmployee();
		void deleteEmployee(int id);
		
}
