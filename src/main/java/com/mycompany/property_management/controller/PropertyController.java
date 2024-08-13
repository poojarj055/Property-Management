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

//    @PostMapping("/propertyDetails")
//    public ResponseEntity<String> propertyDetails(@RequestBody PropertyDTO propertyDTO) {
//        String result = propertyDTO.getTitle() + " " + propertyDTO.getDescription() + " "
//                + propertyDTO.getOwnerName() + " " + propertyDTO.getOwnerEmail() + " " + propertyDTO.getPrice() + " "
//                + propertyDTO.getAddress();
//        return new ResponseEntity<>(result, HttpStatus.CREATED);
//    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
        propertyService.saveProperty(propertyDTO);
//      System.out.println(propertyDTO+ "Property saved successfully");
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>>  getAllProperties() {
        List<PropertyDTO> propertyList=propertyService.getAllProperties();
        ResponseEntity<List<PropertyDTO>> responseEntity=new ResponseEntity<>(propertyList, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        PropertyDTO updatedProperty=propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity=new ResponseEntity<>(updatedProperty, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public void updatePrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
        propertyService.updatePrice(propertyDTO, propertyId);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
         propertyService.deleteProperty(propertyId);
         ResponseEntity<Void> responseEntity=new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
         return responseEntity;
    }
}
