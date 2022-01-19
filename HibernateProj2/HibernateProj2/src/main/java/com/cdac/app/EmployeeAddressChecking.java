package com.cdac.app;

import com.cdac.dao.EmployeeAddressDao;
import com.cdac.entity.Address;

public class EmployeeAddressChecking {

	public static void main(String[] args) {
		EmployeeAddressDao dao = new EmployeeAddressDao();
		
		/*Employee emp = new Employee();
		emp.setName("Majrul Ansari");
		emp.setSalary(5000);
		emp.setDateOfJoining(LocalDate.of(2010, 10, 10));
		dao.add(emp);*/
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setPincode(400001);
		addr.setState("MH");
		dao.add(addr);
		
		
	}
}
