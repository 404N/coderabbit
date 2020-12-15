package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminMapper extends CustomerMapper<Admin> {
    Admin findByUserName(String userName);
}