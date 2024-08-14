package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        // Convert DTO to Entity
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);

        // Save the entity in the database
        userEntity = userRepository.save(userEntity);

        // Convert the saved entity back to DTO
        userDTO = userConverter.convertEntityToDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        // Implementation pending
        return null;
    }
}
