package com.mycompany.property_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>>  getAllProperties() {
        List<PropertyDTO> propertyList=propertyService.getAllProperties();
       return new ResponseEntity<>(propertyList, HttpStatus.OK);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        PropertyDTO updatedProperty=propertyService.updateProperty(propertyDTO, propertyId);
       return new ResponseEntity<>(updatedProperty, HttpStatus.OK);
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public void updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyService.updatePropertyPrice(propertyDTO, propertyId);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
         propertyService.deleteProperty(propertyId);
         return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
