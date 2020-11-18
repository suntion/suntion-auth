package com.pp.auth.model;

/**
 * sys_user_dept 用户部门表
 *
 * @author Scott
 * @date   2020/11/18
 */
public class SysUserDept {
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户ID
     */
    private Long userId;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
