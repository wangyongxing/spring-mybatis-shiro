package com.wyx.domain.permission;

import com.wyx.common.domain.BaseDomain;
import java.io.Serializable;
import java.util.Date;

public class PmsOperator extends BaseDomain implements Serializable {
    private Long id;

    private Long version;

    private String creater;

    private Date createTime;

    private String editor;

    private Date editTime;

    private String status;

    private String remark;

    private String realName;

    private String mobileNo;

    private String loginName;

    private String loginPwd;

    private String type;

    private String salt;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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
        PmsOperator other = (PmsOperator) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
            && (this.getEditTime() == null ? other.getEditTime() == null : this.getEditTime().equals(other.getEditTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getMobileNo() == null ? other.getMobileNo() == null : this.getMobileNo().equals(other.getMobileNo()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getLoginPwd() == null ? other.getLoginPwd() == null : this.getLoginPwd().equals(other.getLoginPwd()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()));
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
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getMobileNo() == null) ? 0 : getMobileNo().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getLoginPwd() == null) ? 0 : getLoginPwd().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        return result;
    }

    public PmsOperator id(Long value) {
        this.id = value;
        return this;
    }

    public PmsOperator version(Long value) {
        this.version = value;
        return this;
    }

    public PmsOperator creater(String value) {
        this.creater = value;
        return this;
    }

    public PmsOperator createTime(Date value) {
        this.createTime = value;
        return this;
    }

    public PmsOperator editor(String value) {
        this.editor = value;
        return this;
    }

    public PmsOperator editTime(Date value) {
        this.editTime = value;
        return this;
    }

    public PmsOperator status(String value) {
        this.status = value;
        return this;
    }

    public PmsOperator remark(String value) {
        this.remark = value;
        return this;
    }

    public PmsOperator realName(String value) {
        this.realName = value;
        return this;
    }

    public PmsOperator mobileNo(String value) {
        this.mobileNo = value;
        return this;
    }

    public PmsOperator loginName(String value) {
        this.loginName = value;
        return this;
    }

    public PmsOperator loginPwd(String value) {
        this.loginPwd = value;
        return this;
    }

    public PmsOperator type(String value) {
        this.type = value;
        return this;
    }

    public PmsOperator salt(String value) {
        this.salt = value;
        return this;
    }
    /**
     * 认证加密的盐
     *
     * @return
     */
    public String getCredentialsSalt() {
        return loginName + salt;
    }
}