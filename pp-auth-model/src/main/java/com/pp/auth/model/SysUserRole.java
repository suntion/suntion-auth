package com.pp.auth.model;

/**
 * sys_user_role 用户角色表
 *
 * @author Scott
 * @date   2020/11/18
 */
public class SysUserRole {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户ID
     */
    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
