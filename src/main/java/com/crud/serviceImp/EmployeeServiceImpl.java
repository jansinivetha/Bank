package com.crud.serviceImp;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.model.Employee;
import com.crud.repository.EmployeeRepo;
import com.crud.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private  EmployeeRepo employeeRepo;
  @Override
  @Transactional
  public Object saveEmployee(Employee employee) {
  Map<String ,Object> map = new HashMap<String ,Object>();
  if(employee.getEmpName().isEmpty()) {
  map.put("status","error");
  map.put("msg","please enter the name");
  }
 else if(employee.getDepartment().isEmpty()) {
 map.put("status","error");
 map.put("msg","please enter the department");
 }  else if(employee.getSalary()==0.0) {
 map.put("status","error");
 map.put("msg","please enter the salary");
 }else {
 employeeRepo.save(employee);
 map.put("status","success");
 map.put("msg","data saved succesfully");
 }
return map;
  }
@Override
public Object getEmployee() 
{
	List <Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	List<Employee> emps = employeeRepo.findAll();
	for(Employee e:emps) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("employeeId", e.getEmployeeId());
		map.put("empName", e.getEmpName());
		map.put("department", e.getDepartment());
		map.put("salary", e.getSalary());
		map.put("dob", e.getDob());
		list.add(map);
		}
	return list;
}
@Override
public Object getEmpById(int empid)
{
	Map<String,Object> map = new HashMap<String,Object>();
	Employee e = employeeRepo.findById(empid).orElse(null);
	if(e != null) 
	{
		map.put("employeeId", e.getEmployeeId());
		map.put("empName", e.getEmpName());
		map.put("department", e.getDepartment());
		map.put("salary", e.getSalary());
		map.put("dob", e.getDob());
		return map;
	}
	return null;
}
    @Override
    public Object getEmployeeByDepartment(String department)
    {
	    List <Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	    List<Employee> emps = employeeRepo.findByDepartment(department);
	    for(Employee e:emps) 
	    {
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put("employeeId", e.getEmployeeId());
		  map.put("empName", e.getEmpName());
		  map.put("department", e.getDepartment());
		  map.put("salary", e.getSalary());
		  //map.put("dob", e.getDob());
		  list.add(map);
		}
	return list;
    }
	@Override
	 @Transactional
	public Object updateEmployee(Employee employee) {
		  Map<String ,Object> map = new HashMap<String ,Object>();
		  if(employee.getEmpName().isEmpty()) 
		  {
		    map.put("status","error");
		    map.put("msg","please enter the name");
		  }
		 else if(employee.getDepartment().isEmpty()) 
		 {
		   map.put("status","error");
		   map.put("msg","please enter the department");
		 }  else if(employee.getSalary()==0.0)
		 {
		   map.put("status","error");
		   map.put("msg","please enter the salary");
		 }else {
		 employeeRepo.saveAndFlush(employee);
		   map.put("status","success");
		   map.put("msg","data updated succesfully");
		 }
		return map;
	}
	@Override
	@Transactional
	public Object deleteEmpById(int empid) {
		Map<String,Object> map = new HashMap<String,Object>();
		Employee e = employeeRepo.findById(empid).orElse(null);
		if(e != null) {
			employeeRepo.delete(e);
			map.put("status","success");
		    map.put("msg","Data Deleted succesfully");
		}else {
			map.put("status","error");
			   map.put("msg","Emp Id not Exist");
			 }
		
		return map;
	}
}


