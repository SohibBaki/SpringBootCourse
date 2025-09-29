package com.luv2code.springboot.thymeleafdemoo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read from data
    @RequestMapping("/ProcessFormVersionTow")
    public String letShoutDude(HttpServletRequest request , Model modele){

        //read thr request parameter from HTML Form
        String theName = request.getParameter("studentName");

        //convert the data to all caps
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo!" + theName;

        // add message to the model
        modele.addAttribute("message",result);

        return "helloworld";
    }

}
