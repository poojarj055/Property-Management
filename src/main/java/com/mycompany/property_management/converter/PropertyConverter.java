package com.mycompany.property_management.converter;

import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;
import com.mycompany.property_management.dto.PropertyDTO;

@Component
public class PropertyConverter {
    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setAddress(propertyDTO.getAddress());
        return propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setAddress(propertyEntity.getAddress());
        return propertyDTO;
    }
}
