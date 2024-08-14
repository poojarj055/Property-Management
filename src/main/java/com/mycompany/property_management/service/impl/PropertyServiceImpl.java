package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.mycompany.property_management.entity.PropertyEntity;


import java.util.*;

@Service

public class PropertyServiceImpl implements PropertyService {

    @Value("{pms.dummy:}")
    private String dummy;

    @Value("{spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = propertyConverter.convertDTOToEntity(propertyDTO);
        propertyEntity=propertyRepository.save(propertyEntity);

        propertyDTO=propertyConverter.convertEntityToDTO(propertyEntity);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        for (PropertyEntity pe : listOfProps) {
            PropertyDTO propertyDTO = propertyConverter.convertEntityToDTO(pe);
            propertyDTOList.add(propertyDTO);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        if (optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity = propertyRepository.save(propertyEntity);
            propertyDTO = propertyConverter.convertEntityToDTO(propertyEntity);
        }
        return propertyDTO;
    }

    @Override
    public void updatePrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        if (optEn.isPresent()) {
            PropertyEntity propertyEntity = optEn.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity = propertyRepository.save(propertyEntity);
        }
    }
    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}