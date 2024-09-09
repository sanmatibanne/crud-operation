package com.example.CrudOperations.service;

import com.example.CrudOperations.entity.Employee;
import com.example.CrudOperations.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> saveEmployee(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployee() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return repository.findByName(name);
    }


    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setCity(employee.getCity());
        return repository.save(existingEmployee);
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "employee removed !! " + id;
    }

}