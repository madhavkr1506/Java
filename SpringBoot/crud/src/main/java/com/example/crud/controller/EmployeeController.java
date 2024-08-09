package com.example.crud.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;
import com.example.crud.service.EmployeeServiceImp;

@RestController
public class EmployeeController {
    

    // @Autowired
    EmployeeService empService = new EmployeeServiceImp();

    // @Autowired
    // EmployeeService empService;

    
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return empService.readEmployee();
    }

    @PostMapping("employees")
    public String postEmployees(@RequestBody Employee emp){
        empService.createEmployee(emp);
        return "Updated Successfully";
    }

    @DeleteMapping("employees/{id}")
    public String removeEmployee(@PathVariable Long id){
        if(empService.deleteEmployee(id)){
            return "Delete Successfully";
        }
        else{
            return "Not found";
        }
    }

}
