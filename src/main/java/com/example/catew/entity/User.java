package com.example.catew.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
/**
 * User entity, the java Object representation of the user table in the database
 */
public class User {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

}
