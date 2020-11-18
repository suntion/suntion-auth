package com.pp.auth.model;

import java.util.Date;

/**
 * sys_role 角色信息表
 * 
 * @author Scott
 * @date   2020/11/18
 */
public class SysRole {
    /**
     * 主键
     */
    private Long roleId;

    /**
     * 父级角色
     */
    private Long parentId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String rolePermissionStr;

    /**
     * 角色数据权限范围
     */
    private String roleDataScope;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createuser;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 更新人
     */
    private String updateuser;

    /**
     * 状态 0失效  1生效 默认1
     */
    private String status;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRolePermissionStr() {
        return rolePermissionStr;
    }

    public void setRolePermissionStr(String rolePermissionStr) {
        this.rolePermissionStr = rolePermissionStr == null ? null : rolePermissionStr.trim();
    }

    public String getRoleDataScope() {
        return roleDataScope;
    }

    public void setRoleDataScope(String roleDataScope) {
        this.roleDataScope = roleDataScope == null ? null : roleDataScope.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}