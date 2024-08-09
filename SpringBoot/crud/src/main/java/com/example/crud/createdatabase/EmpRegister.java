package com.example.crud.createdatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRegister extends JpaRepository<EmpDB,Long>{
    
}
