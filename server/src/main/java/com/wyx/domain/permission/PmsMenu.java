package com.wyx.domain.permission;

import com.wyx.common.domain.BaseDomain;

import java.io.Serializable;
import java.util.Date;

public class PmsMenu extends BaseDomain implements Serializable {
    private Long id;

    private Long version;

    private String creater;

    private Date createTime;

    private String editor;

    private Date editTime;

    private String status;

    private String remark;

    private String isLeaf;

    private Long level;

    private Long parentId;

    private PmsMenu parent;

    private String targetName;

    private String number;

    private String name;

    private String url;

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

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        PmsMenu other = (PmsMenu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
                && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
                && (this.getEditTime() == null ? other.getEditTime() == null : this.getEditTime().equals(other.getEditTime()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getIsLeaf() == null ? other.getIsLeaf() == null : this.getIsLeaf().equals(other.getIsLeaf()))
                && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
                && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
                && (this.getTargetName() == null ? other.getTargetName() == null : this.getTargetName().equals(other.getTargetName()))
                && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
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
        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTargetName() == null) ? 0 : getTargetName().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        return result;
    }

    public PmsMenu id(Long value) {
        this.id = value;
        return this;
    }

    public PmsMenu version(Long value) {
        this.version = value;
        return this;
    }

    public PmsMenu creater(String value) {
        this.creater = value;
        return this;
    }

    public PmsMenu createTime(Date value) {
        this.createTime = value;
        return this;
    }

    public PmsMenu editor(String value) {
        this.editor = value;
        return this;
    }

    public PmsMenu editTime(Date value) {
        this.editTime = value;
        return this;
    }

    public PmsMenu status(String value) {
        this.status = value;
        return this;
    }

    public PmsMenu remark(String value) {
        this.remark = value;
        return this;
    }

    public PmsMenu isLeaf(String value) {
        this.isLeaf = value;
        return this;
    }

    public PmsMenu level(Long value) {
        this.level = value;
        return this;
    }

    public PmsMenu parentId(Long value) {
        this.parentId = value;
        return this;
    }

    public PmsMenu targetName(String value) {
        this.targetName = value;
        return this;
    }

    public PmsMenu number(String value) {
        this.number = value;
        return this;
    }

    public PmsMenu name(String value) {
        this.name = value;
        return this;
    }

    public PmsMenu url(String value) {
        this.url = value;
        return this;
    }

    public PmsMenu getParent() {
        return parent;
    }

    public void setParent(PmsMenu parent) {
        this.parent = parent;
    }
}