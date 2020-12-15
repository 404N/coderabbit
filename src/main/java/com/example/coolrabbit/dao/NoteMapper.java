package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.Note;
import org.springframework.stereotype.Service;

@Service
public interface NoteMapper extends CustomerMapper<Note> {
}