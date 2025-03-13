package com.example.assignment.controller;


import com.example.assignment.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class OpenAIController {

    @Autowired
    private OpenAIService service;

    @GetMapping("/summary/{id}")
    public ResponseEntity<String> getSummary(@PathVariable int id)
    {
        return new ResponseEntity<>(service.getSummary(id), HttpStatus.ACCEPTED);
    }
}
