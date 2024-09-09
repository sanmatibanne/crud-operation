package com.example.CrudOperations.controller;

import com.example.CrudOperations.entity.Employee;
import com.example.CrudOperations.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    //Create employee by providing payload
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }
    //Create employee by providing payload as list i.e multiple employee creation
    @PostMapping("/addEmployees")
    public List<Employee> addEmployee(@RequestBody List<Employee> employee) {
        return service.saveEmployee(employee);
    }

    //get or read all employees
    @GetMapping("/allEmployee")
    public List<Employee> findAllEmployee() {
        return service.getEmployee();
    }
    //read employee for perticular id by passing id as path variable
    @GetMapping("/employeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }
    //read employee for perticular name by passing name as path variable
    @GetMapping("/employeeByName/{name}")
    public Employee findEmployeeByName(@PathVariable String name) {
        return service.getEmployeeByName(name);
    }
    //update or edit the employee
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }
    //deletion of employess by providing a id
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}