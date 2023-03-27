package com.example.catew.dto;

public class ProductInfoDto {
    private Integer id;
    private String description;
    private String product;
    private Integer location;
    private String status;
    private Integer reservee;
    private Integer collect_appointment;
    private Integer distance;
    private Integer owner;

    public ProductInfoDto(Integer id, String description, String product, Integer location, String status, Integer reservee, Integer collect_appointment, Integer distance, Integer owner) {
        this.id = id;
        this.description = description;
        this.product = product;
        this.location = location;
        this.status = status;
        this.reservee = reservee;
        this.collect_appointment = collect_appointment;
        this.distance = distance;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getReservee() {
        return reservee;
    }

    public void setReservee(Integer reservee) {
        this.reservee = reservee;
    }

    public Integer getCollect_appointment() {
        return collect_appointment;
    }

    public void setCollect_appointment(Integer collect_appointment) {
        this.collect_appointment = collect_appointment;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }
}
