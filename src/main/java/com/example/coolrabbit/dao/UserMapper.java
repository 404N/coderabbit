package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper extends CustomerMapper<User> {
    User selectByEmail(String email);

    User selectByEmailAndPassword(String email, String password);
}