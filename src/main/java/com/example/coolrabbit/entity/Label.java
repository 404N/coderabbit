package com.example.coolrabbit.entity;

import java.util.Date;
import javax.persistence.*;

public class Label {
    @Id
    @Column(name = "label_id")
    @GeneratedValue(generator = "UUID")
    private String labelId;

    @Column(name = "label_name")
    private String labelName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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

    /**
     * @return label_name
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * @param labelName
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}