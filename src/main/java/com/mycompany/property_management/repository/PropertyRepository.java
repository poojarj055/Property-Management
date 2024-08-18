package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
    List<PropertyEntity> findAllByUserEntityId(@Param("userId") UserEntity userId);
}