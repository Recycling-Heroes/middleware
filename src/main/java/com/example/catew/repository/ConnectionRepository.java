package com.example.catew.repository;

import com.example.catew.entity.Connection;
import com.example.catew.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * Connection repository, the connection between the connection table and the java Object
 */
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
    Optional<Connection> findById(Integer id);
    Connection[] findByUserId(Integer userId);
}
