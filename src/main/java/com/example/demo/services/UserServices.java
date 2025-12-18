package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.UserEntity;

public interface UserService {

    UserEntity insertUser(UserEntity st);

    List<UserEntity> getAllUser();

    Optional<UserEntity> getOneUser(Long id);

    void deleteUser(Long id);
}