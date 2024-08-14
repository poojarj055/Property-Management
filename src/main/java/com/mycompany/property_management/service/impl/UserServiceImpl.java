package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public UserDTO register(UserDTO userDTO) {
        // Convert DTO to Entity
        Optional<UserEntity>  optionalUserEntity= userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(optionalUserEntity.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("User_Exists");
            errorModel.setMessage("User already exists");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);

        // Save the entity in the database
        userEntity = userRepository.save(userEntity);

        // Convert the saved entity back to DTO
        userDTO = userConverter.convertEntityToDTO(userEntity);

        return userDTO;
    }


    // After
    @Override
    public UserDTO login(String email, String password) {
        // Check for user existence
        Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
        System.out.println(optionalUserEntity);
        // If user exists, convert entity to DTO
        if (optionalUserEntity.isPresent()) {
            System.out.println("User exists");
            UserEntity userEntity = optionalUserEntity.get();
            return userConverter.convertEntityToDTO(userEntity);
        } else {
            // Handle incorrect credentials
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("Invalid_Credentials");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
    }
}