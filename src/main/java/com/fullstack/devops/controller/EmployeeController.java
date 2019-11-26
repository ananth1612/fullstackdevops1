package com.fullstack.devops.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.devops.mysql.model.Employee;
import com.fullstack.devops.mysql.repo.EmployeeRepository;
 

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {
 
  @Autowired
   EmployeeRepository repository;
 
  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    System.out.println("Get all Employees...");
 
    List<Employee> Employees = new ArrayList<>();
    repository.findAll().forEach(Employees::add);
 
    return Employees;
  }
 
  @PostMapping(value = "/employees/create")
  public Employee postEmployee(@RequestBody Employee employee) {
 System.out.println("Create employee");
    Employee _employee = repository.save(new Employee(employee.getFirstname(), employee.getLastname(),employee.getEmail()));
    return _employee;
  }
 
  @DeleteMapping("/employees/{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
    System.out.println("Delete Employee with ID = " + id + "...");
 
    repository.deleteById(id);
 
    return new ResponseEntity<>("Employee has been deleted!", HttpStatus.OK);
  }
 
  @DeleteMapping("/employees/delete")
  public ResponseEntity<String> deleteAllEmployees() {
    System.out.println("Delete All Employees...");
    System.out.println("Git commit Test");
 
    repository.deleteAll();
 
    return new ResponseEntity<>("All Employees have been deleted!", HttpStatus.OK);
  }
 
  @GetMapping(value = "employees/fisrtname/{firstname}")
  public List<Employee> findByAge(@PathVariable String firstname) {
 
    List<Employee> Employees = repository.findByFirstname(firstname);
    return Employees;
  }
 
  @PutMapping("/Employees/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
    System.out.println("Update Employee with ID = " + id + "...");
 
    Optional<Employee> EmployeeData = repository.findById(id);
 
    if (EmployeeData.isPresent()) {
      Employee _employee = EmployeeData.get();
      _employee.setFirstname(employee.getFirstname());
      _employee.setLastname(employee.getLastname());
      _employee.setEmail(employee.getEmail());
      
      return new ResponseEntity<>(repository.save(_employee), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}