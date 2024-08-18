package com.mycompany.property_management.dto;

public class PropertyDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;
    private Long userId; // Change from UserEntity to Long

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getUserId() { // Change from UserEntity to Long
        return userId;
    }

    public void setUserId(Long userId) { // Change from UserEntity to Long
        this.userId = userId;
    }
}
