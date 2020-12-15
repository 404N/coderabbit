package com.example.coolrabbit.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface LabelService {
    Set<String> getAllLabel();
}
