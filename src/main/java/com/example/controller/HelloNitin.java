package com.example.controller;

import com.example.model.HelloWorldBean;
import com.example.service.GetinstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloNitin {

    @Autowired
    private GetinstanceService service;

   @GetMapping("/welcome")
   public String welcome(){

               return "Hello World";

   }

    // Application should display "healthy:true" for "/"
    @GetMapping("/")
    public String iamhealthy(){

        return "healthy:true";
    }

    // it should return "hello-world" when user try to access "/hello-world-bean"
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){

       return new HelloWorldBean("Hello World");

   }

   //it should display "hello-nitin V3 <instance name on which app is running>" when user try to access "/hello-nitin"
   // create service for getting instance name
   @GetMapping("/hello-nitin")
   public String hellonitin(){

       return "Hello World" + " V3 " + service.retriveInstanceOfInfo();
   }


    // it should display "hello-world <path variable>" when user try to access "/hello-world/path-variable/{name}"
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){

       return new HelloWorldBean(String.format("Hello World, %s", name)); // this will pring " Hello World, <name passed>"
    }

}
