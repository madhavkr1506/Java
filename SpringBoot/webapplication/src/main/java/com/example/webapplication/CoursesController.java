package com.example.webapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpSession;

@Controller
public class CoursesController {
    // @RequestMapping("/courses")
    // public String courses(HttpServletRequest req){
    //     HttpSession session = req.getSession();
    //     String name = req.getParameter("name");
    //     // System.out.println("Welcome to the Spring Boot Class!");
    //     // System.out.println(name);
    //     session.setAttribute("name", name);
    //     return "course.html";
    // }

    @RequestMapping("/courses")
    public ModelAndView courses(@RequestParam("kname") String name){
        ModelAndView mv = new ModelAndView();
        mv.addObject("kname", name);
        mv.setViewName("course.html");
        return mv;
    }
}
