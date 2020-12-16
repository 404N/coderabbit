package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface UserMapper extends CustomerMapper<User> {
    User selectByEmail(String email);

    User selectByEmailAndPassword(String email, String password);
}