package com.wyx.domain.permission;

import com.wyx.common.domain.BaseDomain;
import java.io.Serializable;
import java.util.Date;

public class PmsRolePermission extends BaseDomain implements Serializable {
    private Long id;

    private Long version;

    private String creater;

    private Date createTime;

    private String editor;

    private Date editTime;

    private String status;

    private String remark;

    private Long roleId;

    private Long permissionId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
        PmsRolePermission other = (PmsRolePermission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
            && (this.getEditTime() == null ? other.getEditTime() == null : this.getEditTime().equals(other.getEditTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEditor() == null) ? 0 : getEditor().hashCode());
        result = prime * result + ((getEditTime() == null) ? 0 : getEditTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        return result;
    }

    public PmsRolePermission id(Long value) {
        this.id = value;
        return this;
    }

    public PmsRolePermission version(Long value) {
        this.version = value;
        return this;
    }

    public PmsRolePermission creater(String value) {
        this.creater = value;
        return this;
    }

    public PmsRolePermission createTime(Date value) {
        this.createTime = value;
        return this;
    }

    public PmsRolePermission editor(String value) {
        this.editor = value;
        return this;
    }

    public PmsRolePermission editTime(Date value) {
        this.editTime = value;
        return this;
    }

    public PmsRolePermission status(String value) {
        this.status = value;
        return this;
    }

    public PmsRolePermission remark(String value) {
        this.remark = value;
        return this;
    }

    public PmsRolePermission roleId(Long value) {
        this.roleId = value;
        return this;
    }

    public PmsRolePermission permissionId(Long value) {
        this.permissionId = value;
        return this;
    }
}