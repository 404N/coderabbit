package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.Folder;
import org.springframework.stereotype.Service;

@Service
public interface FolderMapper extends CustomerMapper<Folder> {
}