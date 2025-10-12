package com.luv2code.springboot.thymeleafdemoo.controller;

import com.luv2code.springboot.thymeleafdemoo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;

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

@PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        // log the input data
    System.out.println("theStudent :" + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
}




}
