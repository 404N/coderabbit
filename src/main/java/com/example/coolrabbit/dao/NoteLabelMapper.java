package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.NoteLabel;
import org.springframework.stereotype.Service;

@Service
public interface NoteLabelMapper extends CustomerMapper<NoteLabel> {
}