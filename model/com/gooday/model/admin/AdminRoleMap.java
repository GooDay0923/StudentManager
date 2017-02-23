package com.gooday.model.admin;

import java.io.Serializable;

/**
 * @author 
 */
public class AdminRoleMap implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long adminId;

    /**
     * 角色id
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}