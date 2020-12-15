package com.example.coolrabbit.entity;

import javax.persistence.*;

public class Note {
    @Id
    @Column(name = "note_id")
    @GeneratedValue(generator = "UUID")
    private String noteId;

    /**
     * 笔记标题
     */
    @Column(name = "note_title")
    private String noteTitle;

    /**
     * 所属人id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 笔记内容
     */
    @Column(name = "note_content")
    private String noteContent;

    /**
     * 0表示私人，1表示公开
     */
    @Column(name = "is_private")
    private Integer isPrivate;

    /**
     * 所属文件夹
     */
    @Column(name = "folder_id")
    private String folderId;

    /**
     * @return note_id
     */
    public String getNoteId() {
        return noteId;
    }

    /**
     * @param noteId
     */
    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    /**
     * 获取笔记标题
     *
     * @return note_title - 笔记标题
     */
    public String getNoteTitle() {
        return noteTitle;
    }

    /**
     * 设置笔记标题
     *
     * @param noteTitle 笔记标题
     */
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    /**
     * 获取所属人id
     *
     * @return user_id - 所属人id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置所属人id
     *
     * @param userId 所属人id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取笔记内容
     *
     * @return note_content - 笔记内容
     */
    public String getNoteContent() {
        return noteContent;
    }

    /**
     * 设置笔记内容
     *
     * @param noteContent 笔记内容
     */
    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    /**
     * 获取0表示私人，1表示公开
     *
     * @return is_private - 0表示私人，1表示公开
     */
    public Integer getIsPrivate() {
        return isPrivate;
    }

    /**
     * 设置0表示私人，1表示公开
     *
     * @param isPrivate 0表示私人，1表示公开
     */
    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    /**
     * 获取所属文件夹
     *
     * @return folder_id - 所属文件夹
     */
    public String getFolderId() {
        return folderId;
    }

    /**
     * 设置所属文件夹
     *
     * @param folderId 所属文件夹
     */
    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }
}