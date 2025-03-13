package com.example.assignment.service;


import com.example.assignment.model.Blog;
import com.example.assignment.repository.BlogRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

    @Autowired
    private BlogRepo repo;
    private RestTemplate template;

    public OpenAIService() {
        this.template = new RestTemplate();
    }


    private String aiUrl="https://api.cohere.ai/v1/summarize";
    private String aikey="jeqHHILiCCWjPm0SHXLyb4CDH0wYuVTkdfVr8eYh";

    public String getSummary(int id) {
        Blog blog=repo.findById(id).orElse(new Blog());
        if(blog.getContent().equals(""))
        {
            return "blog not found";
        }

        JSONObject object=new JSONObject();
        object.put("text",blog.getContent());
        object.put("model","command");
        object.put("length","short");

        HttpHeaders headers=new HttpHeaders();
        headers.set("Authorization","Bearer "+aikey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request=new HttpEntity<>(object.toString(),headers);
        ResponseEntity<String> response = template.exchange(aiUrl, HttpMethod.POST, request, String.class);
        return new JSONObject(response.getBody()).optString("summary","no summary found");
    }
}
