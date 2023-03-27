package com.example.catew.dto;

public class UserDto {
    private Integer id;
    private String email;
    private Boolean isCompany;
    private String token;

    public UserDto(Integer id, String email, Boolean isCompany, String token) {
        this.id = id;
        this.email = email;
        this.isCompany = isCompany;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCompany() {
        return isCompany;
    }

    public void setCompany(Boolean company) {
        isCompany = company;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
