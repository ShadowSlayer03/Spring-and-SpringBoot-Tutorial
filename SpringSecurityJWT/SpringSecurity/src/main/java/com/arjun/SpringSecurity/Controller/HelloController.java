package com.arjun.SpringSecurity.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request){
        return "Hello this is Spring Security, this is the session ID: " + request.getSession().getId();
    }

    @GetMapping("/lessgo")
    public String greet1(HttpServletRequest request){
        return "Hello less go! " + request.getSession().getId();
    }
}
