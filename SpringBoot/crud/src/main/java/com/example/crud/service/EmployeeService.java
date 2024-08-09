package com.example.crud.service;

import java.util.List;

import com.example.crud.model.Employee;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployee();
    boolean deleteEmployee(Long id);
}
