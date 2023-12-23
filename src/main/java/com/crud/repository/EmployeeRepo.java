package com.crud.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.crud.model.Employee;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Integer>
{
    @Query("select e from Employee e where e.department=:department")
	List<Employee> findByDepartment(@Param("department")String department);

}
