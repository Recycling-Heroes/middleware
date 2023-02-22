package com.example.catew.controller;

import com.example.catew.entity.Product;
import com.example.catew.entity.User;
import com.example.catew.repository.ProductRepository;
import com.example.catew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/frontend")
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/frontend/getProducts?user_id=1";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer token");
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        return "login" + " " + email + " " + password;
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("password") String password) {
        return "register" + " " + email + " " + password;
    }
}
