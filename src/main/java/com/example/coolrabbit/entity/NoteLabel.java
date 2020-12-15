package com.example.coolrabbit.entity;

import javax.persistence.*;

@Table(name = "note_label")
public class NoteLabel {
    @Id
    @Column(name = "note_id")
    @GeneratedValue(generator = "UUID")
    private String noteId;

    @Id
    @Column(name = "label_id")
    private String labelId;

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
     * @return label_id
     */
    public String getLabelId() {
        return labelId;
    }

    /**
     * @param labelId
     */
    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }
}