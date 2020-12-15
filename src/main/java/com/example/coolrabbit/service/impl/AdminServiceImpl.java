package com.example.coolrabbit.service.impl;

import com.example.coolrabbit.dao.AdminMapper;
import com.example.coolrabbit.entity.Admin;
import com.example.coolrabbit.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService {
    final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public Admin findByUserName(String userName) {
        return adminMapper.findByUserName(userName);
    }
}
