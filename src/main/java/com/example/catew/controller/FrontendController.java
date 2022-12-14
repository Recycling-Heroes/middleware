package com.example.catew.controller;

import com.example.catew.entity.Product;
import com.example.catew.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/frontend")
public class FrontendController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public String getAllForUser() {
        return "User";
    }

    @GetMapping("/test")
    public String getAllForUser_test() {
//        return productRepository.findByID("1").toString();
        return "User";
    }

    @GetMapping("/test/{id}")
    public Optional<Product> getAllForUser(@PathVariable("id") String id) {
        return productRepository.findById(id);
//        return "User";
    }
}
