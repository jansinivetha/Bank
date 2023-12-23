package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Employee;
import com.crud.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController 
{
@Autowired
private EmployeeService employeeService;

@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
@PostMapping("/saveEmp")
public Object saveEmp(@RequestBody Employee employee)
{
	return (employeeService.saveEmployee(employee));
}
//@RequestMapping(value = "/saveEmp", method = RequestMethod.POST)
@GetMapping("/fetchemps")
public Object getAllEmps() {
	return(employeeService.getEmployee());
}
@GetMapping("/fetchEmpbyid/{id}")
public Object getEmpById(@PathVariable int id) 
{
	return(employeeService.getEmpById(id));
}
@GetMapping("/fetchEmpByDepartment")
public Object getEmpsByDepartment(@RequestParam("department") String department) 
{
	return(employeeService.getEmployeeByDepartment(department));
}
@PutMapping("/updateEmp")
public Object updateEmp(@RequestBody Employee employee)
   {
	   return (employeeService.updateEmployee(employee));
   }
@DeleteMapping("/deleteEmpbyid/{id}")
public Object deleteEmpById(@PathVariable int id) 
   {
	  return(employeeService.deleteEmpById(id));
   }

}
