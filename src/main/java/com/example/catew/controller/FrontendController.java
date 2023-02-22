package com.example.catew.controller;

import com.example.catew.entity.Connection;
import com.example.catew.entity.Product;
import com.example.catew.entity.User;
import com.example.catew.repository.ConnectionRepository;
import com.example.catew.repository.ProductRepository;
import com.example.catew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/frontend")
public class FrontendController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ConnectionRepository connectionRepository;

    @GetMapping("/getProducts")
    public Product[] getProducts(@RequestParam("user_id") Integer id) {
        System.out.println(id);
        Connection[] connections =  connectionRepository.findByUserId(id);
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i < connections.length; i++) {
            Optional<Product> product = productRepository.findById(connections[i].getProductId());
            product.ifPresent(products::add);
        }
        return products.toArray(new Product[0]);
    }
}
