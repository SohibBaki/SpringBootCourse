package com.luv2code.springboot.thymeleafdemoo.controller;

import com.luv2code.springboot.thymeleafdemoo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String shoeForm(Model theModel){

        // create a new student object
        Student theStudent = new Student();

        //add student object to the model
        theModel.addAttribute("student",theStudent);

        return "student-form";
    }
}
