package com.crud.service;

import com.crud.model.Employee;

public interface EmployeeService
{
	public  Object saveEmployee(Employee employee);
    public  Object getEmployee();
    public  Object getEmpById(int empid);
    public  Object getEmployeeByDepartment(String department);
	public  Object updateEmployee(Employee employee);
    public  Object deleteEmpById(int empid);
}
