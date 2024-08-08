package com.example.formsubmission.formcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class formController {
    @RequestMapping("/form")
    public String showForm(){
        
        return "form";
    }

    @PostMapping("/details")
    public String submitForm(@RequestParam("cid") String id, @RequestParam("cname") String name, @RequestParam("cemail") String email,ModelMap modelMap){
        
        modelMap.put("cid", id);
        modelMap.put("cname", name);
        modelMap.put("cemail", email);

        return "result";
    }
}
