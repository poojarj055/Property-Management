package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.UserEntity;

import java.util.List;

public interface PropertyService {
  PropertyDTO saveProperty(PropertyDTO propertyDTO);
  List<PropertyDTO> getAllProperties();

  List<PropertyDTO> getAllPropertiesForUser(UserEntity userId);

  PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

  PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);

  PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);

  void deleteProperty(Long propertyId);

}