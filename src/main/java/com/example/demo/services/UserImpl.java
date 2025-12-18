package com.example.demo.services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.demo.entity.UserEntity;

@Service
public class UserImpl implements UserService {

    private final Map<Long, UserEntity> store = new HashMap<>();
    private long counter = 1;

    @Override
    public UserEntity insertUser(UserEntity st) {
        st.setId(counter++);
        store.put(st.getId(), st);
        return st;
    }

    @Override
    public List<UserEntity> getAllStudents() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Student> getOneStudent(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteStudent(Long id) {
        store.remove(id);
    }
}