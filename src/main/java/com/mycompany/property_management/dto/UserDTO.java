package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is mandatory")
    @NotEmpty(message = "Owner Email cannot be empty")
    @Size(min = 1, max = 50, message = "Owner Email should be between 1 to 50 characters in length")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String password;

    private String houseNo;
    private String street;
    private String city;
    private String postalCode;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public @NotNull(message = "Owner Email is mandatory") @NotEmpty(message = "Owner Email cannot be empty") @Size(min = 1, max = 50, message = "Owner Email should be between 1 to 50 characters in length") String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(@NotNull(message = "Owner Email is mandatory") @NotEmpty(message = "Owner Email cannot be empty") @Size(min = 1, max = 50, message = "Owner Email should be between 1 to 50 characters in length") String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public @NotNull(message = "Password cannot be null") @NotEmpty(message = "Password cannot be empty") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(message = "Password cannot be null") @NotEmpty(message = "Password cannot be empty") String password) {
        this.password = password;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}