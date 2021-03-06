package com.gooday.model.resource;

import java.io.Serializable;

/**
 * @author 
 */
public class Resource implements Serializable {
	
	public final static Short TYPE_CATALOG = 0;
	public final static Short TYPE_MENU = 1;
	public final static Short TYPE_BUTTON = 2;
	
    private Long id;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long pId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * url
     */
    private String url;
    
    /**
     * 权限
     */
    private String permission;

    public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Short type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单排序
     */
    private Short sort;

    /**
     * 删除 0：否 1：是
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private Integer gmtCreate;

    /**
     * 修改时间
     */
    private Integer gmtModified;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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
}