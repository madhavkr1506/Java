package com.example.dependency;

import org.springframework.stereotype.Component;

@Component
public class Technologies {
    private int techid;
    private String techname;

    public int gettechid(){
        return techid;
    }
    public void settechid(int techid){
        this.techid = techid;
    }

    public String gettechname(){
        return techname;
    }
    public void settechname(String techname){
        this.techname = techname;
    }
    public void tech(){
        System.out.println("Completed");
    }
}


