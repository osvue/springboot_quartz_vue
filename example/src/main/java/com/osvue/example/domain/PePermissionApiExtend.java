package com.osvue.example.domain;

import java.io.Serializable;

/**
 * @author 
 */
public class PePermissionApiExtend implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 权限等级，1为通用接口权限，2为需校验接口权限
     */
    private Integer apiLevel;

    /**
     * 请求类型
     */
    private String apiMethod;

    /**
     * 链接
     */
    private String apiUrl;

    /**
     * 主键
     */
    private Long permissionId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(Integer apiLevel) {
        this.apiLevel = apiLevel;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PePermissionApiExtend other = (PePermissionApiExtend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getApiLevel() == null ? other.getApiLevel() == null : this.getApiLevel().equals(other.getApiLevel()))
            && (this.getApiMethod() == null ? other.getApiMethod() == null : this.getApiMethod().equals(other.getApiMethod()))
            && (this.getApiUrl() == null ? other.getApiUrl() == null : this.getApiUrl().equals(other.getApiUrl()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApiLevel() == null) ? 0 : getApiLevel().hashCode());
        result = prime * result + ((getApiMethod() == null) ? 0 : getApiMethod().hashCode());
        result = prime * result + ((getApiUrl() == null) ? 0 : getApiUrl().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apiLevel=").append(apiLevel);
        sb.append(", apiMethod=").append(apiMethod);
        sb.append(", apiUrl=").append(apiUrl);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}