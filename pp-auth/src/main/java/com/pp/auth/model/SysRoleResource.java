package com.pp.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_role_resource 角色资源表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
public class SysRoleResource {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 资源ID
     */
    private Long resourceId;

}
