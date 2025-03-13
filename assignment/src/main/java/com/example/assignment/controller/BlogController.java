package com.example.assignment.controller;

import com.example.assignment.model.Blog;
import com.example.assignment.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private BlogService service;

    @PostMapping("/add")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog)
    {
        blog.setCreatedAt(new Date());
        Blog blog1= service.addBlog(blog);
        return blog1!=null?new ResponseEntity<>(blog1, HttpStatus.ACCEPTED):new ResponseEntity<>(blog1,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Blog>> fetchBlog()
    {
        return new ResponseEntity<>(service.fetchBlog(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Blog> fetchBlogById(@PathVariable int id)
    {
        return new ResponseEntity<>(service.fetchBlogById(id),HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog)
    {
        return new ResponseEntity<>(service.updateBlog(blog),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable int id)
    {
        service.deleteBlog(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
