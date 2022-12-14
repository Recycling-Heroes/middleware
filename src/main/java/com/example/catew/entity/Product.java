package com.example.catew.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Id
    private String id;

    @Column(name = "content")
    private String content;

    // Getters and setters
}
