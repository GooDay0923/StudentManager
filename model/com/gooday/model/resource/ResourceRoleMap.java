package com.gooday.model.resource;

import java.io.Serializable;

/**
 * @author 
 */
public class ResourceRoleMap implements Serializable {
    private Long id;

    /**
     * 资源id
     */
    private Long resourceId;

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

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}