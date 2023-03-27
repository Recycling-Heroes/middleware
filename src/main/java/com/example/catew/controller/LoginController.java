package com.example.catew.controller;

import com.example.catew.dto.*;
import com.example.catew.entity.Connection;
import com.example.catew.entity.Product;
import com.example.catew.entity.User;
import com.example.catew.repository.ConnectionRepository;
import com.example.catew.repository.ProductRepository;
import com.example.catew.repository.UserRepository;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/frontend")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Value("${collew.url}")
    private String collewUrl;

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<LoginDto> request = new HttpEntity<>(new LoginDto(email, password));
        UserDto userDto = restTemplate.postForObject(collewUrl + "/api/v1/account/login", request, UserDto.class);

        userRepository.findById(userDto.getId()).orElseGet(() -> {
            UserInfoDto userInfoDto = restTemplate.getForObject(collewUrl + "/api/v1/account/" + userDto.getId(), UserInfoDto.class);
            User user = new User();
            user.setId(userInfoDto.getId());
            user.setName(userInfoDto.getName());
            user.setEmail(userInfoDto.getEmail());
            return userRepository.save(user);
        });

        Connection[] connections = connectionRepository.findByUserId(userDto.getId());
        boolean moreProducts = true;
        ArrayList<ProductInfoDto> products = new ArrayList<>(List.of(restTemplate.getForObject(collewUrl + "/api/v1/product?authorization=" + userDto.getToken() + "&state=sold&associativity=owner", ProductInfoDto[].class)));
        while (moreProducts) {
            try{
                ProductInfoDto[] newProducts = restTemplate.getForObject(collewUrl + "/api/v1/product?authorization=" + userDto.getToken() + "&state=sold&associativity=owner&afterId=" + products.get(-1).getId(), ProductInfoDto[].class);
                products.addAll(List.of(newProducts));
            } catch (HttpClientErrorException e) {
                moreProducts = false;
            }
        }
        if(connections.length < products.size()) {
            for(int i = connections.length; i < products.size(); i++) {
                Connection connection = new Connection();
                connection.setUserId(userDto.getId());
                int finalI = i;
                productRepository.findById(products.get(i).getId().toString()).orElseGet(() -> {
                    Product product = new Product();
                    product.setId(products.get(finalI).getId().toString());
                    product.setContent(products.get(finalI).getProduct());
                    return productRepository.save(product);
                });
                connection.setProductId(products.get(i).getId().toString());
                connectionRepository.save(connection);
            }
        }
        return userDto.getToken();
    }

    @PostMapping("/register")
    public String register(@RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("password") String password) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<RegisterDto> request = new HttpEntity<>(new RegisterDto(email, name, password));
        UserInfoDto userInfoDto = restTemplate.postForObject(collewUrl + "/api/v1/account/register", request, UserInfoDto.class);

        User user = new User();
        user.setId(userInfoDto.getId());
        user.setName(userInfoDto.getName());
        user.setEmail(userInfoDto.getEmail());
        userRepository.save(user);
        return "OK";
    }
}
