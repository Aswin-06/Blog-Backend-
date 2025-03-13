package com.example.assignment.service;

import com.example.assignment.model.Blog;
import com.example.assignment.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepo repo;

    public Blog addBlog(Blog blog) {
        return repo.save(blog);
    }

    public List<Blog> fetchBlog() {
        return repo.findAll();
    }

    public Blog fetchBlogById(int id) {
        return repo.findById(id).orElse(new Blog());
    }

    public Blog updateBlog(Blog blog) {
        return repo.save(blog);
    }

    public void deleteBlog(int id) {
        repo.deleteById(id);
    }
}

