package com.pp.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_user_dept 用户部门表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
public class SysUserDept {
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 用户ID
     */
    private Long userId;

}
