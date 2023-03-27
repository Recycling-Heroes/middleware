package com.example.catew.repository;

import com.example.catew.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * Product repository, the connection between the product table and the java Object
 */
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findById(String id);
    Optional<Product> findContentById(String id);
}
