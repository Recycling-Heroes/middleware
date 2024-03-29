package com.example.catew.repository;

import com.example.catew.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
/**
 * User repository, the connection between the user table and the java Object
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    String findNameById(Integer id);
}

