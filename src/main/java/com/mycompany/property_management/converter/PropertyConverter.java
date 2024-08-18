package com.mycompany.property_management.converter;

import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    @Autowired
    private UserRepository userRepository;

    public PropertyEntity convertDTOToEntity(PropertyDTO propertyDTO) {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setAddress(propertyDTO.getAddress());
        pe.setPrice(propertyDTO.getPrice());
        pe.setDescription(propertyDTO.getDescription());

        // Fetch the UserEntity based on userId from DTO
        if (propertyDTO.getUserId() != null) {
            UserEntity userEntity = userRepository.findById(propertyDTO.getUserId()).orElse(null);
            pe.setUserEntity(userEntity);
        }

        return pe;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity) {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setDescription(propertyEntity.getDescription());

        // Set the userId as the ID of the associated UserEntity
        if (propertyEntity.getUserEntity() != null) {
            propertyDTO.setUserId(propertyEntity.getUserEntity().getId());
        }

        return propertyDTO;
    }
}
