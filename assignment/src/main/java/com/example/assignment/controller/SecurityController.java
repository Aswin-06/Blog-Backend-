package com.example.assignment.controller;

import com.example.assignment.model.User;
import com.example.assignment.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private SecurityService securityService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user)
    {
        if(securityService.register(user))
            return new ResponseEntity<>("success", HttpStatus.ACCEPTED);

        return new ResponseEntity<>("Username already available",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user)
    {
        String token = securityService.verify(user);
        if(token!="failure")
        {
            return new ResponseEntity<>(token,HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(token,HttpStatus.BAD_REQUEST);
        }
    }

}
