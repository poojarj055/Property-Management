package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;

import java.util.List;

public interface PropertyService {
  PropertyDTO saveProperty(PropertyDTO propertyDTO);
  List<PropertyDTO> getAllProperties();
  PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
  void deleteProperty(Long propertyId);
  void updatePrice(PropertyDTO propertyDTO, Long propertyId);
}