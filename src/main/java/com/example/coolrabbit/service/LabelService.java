package com.example.coolrabbit.service;

import com.example.coolrabbit.entity.Label;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface LabelService {
    List<Label> getAllLabel();
}
