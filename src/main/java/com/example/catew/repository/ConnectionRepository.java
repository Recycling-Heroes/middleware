package com.example.catew.repository;

import com.example.catew.entity.Connection;
import com.example.catew.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
    Optional<Connection> findById(Integer id);
    Connection[] findByUserId(Integer userId);
}
