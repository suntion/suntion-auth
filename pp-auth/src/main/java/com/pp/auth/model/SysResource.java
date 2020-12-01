package com.pp.auth.model;

import com.pp.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_resource 菜单信息表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
public class SysResource extends BaseEntity {
    /**
     * 主键
     */
    private Long resourceId;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 应用（从数据字典来）
     */
    private String application;

    /**
     * 菜单名称
     */
    private String resourceName;

    /**
     * 菜单类型 M目录 C 菜单 F按钮
     */
    private String type;

    /**
     * 菜单状态 显示/隐藏
     */
    private String visible;

    /**
     * 菜单权限字符串
     */
    private String permissionStr;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 显示顺序
     */
    private Integer orderNum;

    /**
     * 扩展数据
     */
    private String extdata;

}
