package com.example.coolrabbit.entity;

import javax.persistence.*;

public class Folder {
    @Id
    @Column(name = "folder_id")
    @GeneratedValue(generator = "UUID")
    private String folderId;

    /**
     * 所属用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 文件夹名称
     */
    @Column(name = "folder_name")
    private String folderName;

    /**
     * 上级文件夹id
     */
    @Column(name = "father_id")
    private String fatherId;

    /**
     * @return folder_id
     */
    public String getFolderId() {
        return folderId;
    }

    /**
     * @param folderId
     */
    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    /**
     * 获取所属用户id
     *
     * @return user_id - 所属用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置所属用户id
     *
     * @param userId 所属用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取文件夹名称
     *
     * @return folder_name - 文件夹名称
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * 设置文件夹名称
     *
     * @param folderName 文件夹名称
     */
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    /**
     * 获取上级文件夹id
     *
     * @return father_id - 上级文件夹id
     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     * 设置上级文件夹id
     *
     * @param fatherId 上级文件夹id
     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }
}