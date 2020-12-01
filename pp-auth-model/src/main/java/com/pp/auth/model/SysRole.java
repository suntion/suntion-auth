package com.pp.auth.model;

import com.pp.common.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_role 角色信息表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
public class SysRole extends BaseEntity {
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

}
