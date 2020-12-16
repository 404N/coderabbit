package com.example.coolrabbit.dao;

import com.example.coolrabbit.core.CustomerMapper;
import com.example.coolrabbit.entity.NoteLabel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
public interface NoteLabelMapper extends CustomerMapper<NoteLabel> {
}