package com.example.id6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.id6.model.geminimodel;
import com.example.id6.service.geminiservice;

@RestController
public class geminicontroller {
    
    @Autowired
    private geminiservice geminiserviceObject;

    @PostMapping("/")
    public String postMethod(@RequestParam("question") String question){
        geminiserviceObject.setQuestion(question);
        geminimodel modelclassobject = geminiserviceObject.findAnswer();
        
        return modelclassobject.getAnswer();
        
    }

}
