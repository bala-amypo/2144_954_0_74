package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entity.UserEntity;

public interface UserServices {

    UserEntity insertUser(UserEntity user);

    List<UserEntity> getAllUser();

    Optional<UserEntity> getOneUser(Long id);
    
    void deleteUser(Long id);
}
