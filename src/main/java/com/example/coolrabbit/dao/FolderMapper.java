package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.Folder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface FolderMapper extends CustomerMapper<Folder> {
}