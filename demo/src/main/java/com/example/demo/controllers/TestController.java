package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController{

    @RequestMapping("/primeiro-projeto")
    public String Test(){
        return "teste com sucesso 2!";
    }
}