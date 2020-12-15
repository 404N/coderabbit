package com.example.coolrabbit.service;

import com.example.coolrabbit.entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin findByUserName(String username);
}
