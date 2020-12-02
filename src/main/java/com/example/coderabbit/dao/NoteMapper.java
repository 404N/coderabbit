package com.example.coderabbit.dao;

import com.example.coderabbit.entity.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer noteId);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}