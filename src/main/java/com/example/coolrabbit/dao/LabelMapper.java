package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.Label;
import org.springframework.stereotype.Service;

@Service
public interface LabelMapper extends CustomerMapper<Label> {
}