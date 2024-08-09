package com.example.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.createdatabase.EmpDB;
import com.example.crud.createdatabase.EmpRegister;
import com.example.crud.model.Employee;

public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmpRegister empRepo;

    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmpDB empdb = new EmpDB();
        BeanUtils.copyProperties(employee, empdb);
        empRepo.save(empdb);

        // employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployee() {
        List<EmpDB> employeesList =  empRepo.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmpDB empDB : employeesList){
            Employee emp = new Employee();
            emp.setName(empDB.getName());
            emp.setEmail(empDB.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        // for(Employee employee : employees){
        //     if(employee.getId().equals(id)){
        //         employees.remove(employee);
        //         return true;
        //     }
        // }
        return false;
    }

    
}
