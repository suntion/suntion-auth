package com.pp.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_user_role 用户角色表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
public class SysUserRole {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户ID
     */
    private Long userId;

}
