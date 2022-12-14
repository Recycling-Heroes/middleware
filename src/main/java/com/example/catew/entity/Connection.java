package com.example.catew.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "connection")
@Getter
@Setter
public class Connection {
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "recycled")
    private Boolean recycled;

    @Column(name = "recycled_date")
    private Date recycledDate;

    // Getters and setters
}
