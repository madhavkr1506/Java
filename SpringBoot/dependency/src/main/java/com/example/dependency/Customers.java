package com.example.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Customers {
    private int custid;
    private String custname;
    private String coursename;
    @Autowired
    private Technologies techdetails;

    public Technologies gettechdetails(){
        return techdetails;
    }
    public void settechdetails(Technologies techdetails){
        this.techdetails = techdetails;
    }

    public int getcustid(){
        return custid;
    }
    public void setcustid(int custid){
        this.custid = custid;  
    }

    public String getcustname(){
        return custname;
    }
    public void setcustname(String custname){
        this.custname = custname;  
    }

    public String getcoursename(){
        return coursename;
    }
    public void setcoursename(String coursename){
        this.coursename = coursename;  
    }

    public void display(){
        System.out.println("Customers Object Returened Successfully");

        techdetails.tech();
    }
}
