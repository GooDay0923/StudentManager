package com.gooday.model.student;

import java.io.Serializable;

/**
 * @author 
 */
public class Student implements Serializable {
    private Long id;

    /**
     * 学生名
     */
    private String name;

    /**
     * 性别 0：未知 1：男  2：女
     */
    private Boolean sex;

    /**
     * 出生日期
     */
    private Integer birthday;

    /**
     * 入学日期
     */
    private Integer enrollmentDate;

    /**
     * 创建时间
     */
    private Integer gmtCreate;

    /**
     * 修改时间
     */
    private Integer gmtModified;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String modifiedBy;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Integer enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Integer gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Integer gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}