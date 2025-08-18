package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class TenisCoach implements Coach{
    public TenisCoach(){
        System.out.println("In Constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Practise your backhand volley";
    }

}
