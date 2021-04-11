package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloNitin {

   @RequestMapping("/welcome")
   @ResponseBody
   public String welcome(){

               return "Hello World";

   }

}
