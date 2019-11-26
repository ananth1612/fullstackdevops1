package com.fullstack.devops.mysql.repo;
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;

import com.fullstack.devops.mysql.model.Employee;
 
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	  List<Employee> findByFirstname(String firstname);

}