package com.bin.demo.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {

    @GetMapping("/index")
    public String userIndex()
    {
        return "index";
    }

    @GetMapping("/admin")
    public String adminIndex()
    {
        return "admin";
    }

}

