package com.example.coderabbit.dao;

import com.example.coderabbit.entity.Folder;

public interface FolderMapper {
    int deleteByPrimaryKey(Integer folderId);

    int insert(Folder record);

    int insertSelective(Folder record);

    Folder selectByPrimaryKey(Integer folderId);

    int updateByPrimaryKeySelective(Folder record);

    int updateByPrimaryKey(Folder record);
}