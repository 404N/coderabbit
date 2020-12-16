package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface AdminMapper extends CustomerMapper<Admin> {
    Admin findByUserName(String userName);
}