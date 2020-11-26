package com.pp.auth.model;

import com.pp.common.base.BaseEntity;
import lombok.Data;

/**
 * sys_post 岗位
 *
 * @author Scott
 * @date   2020/11/18
 */
@Data
public class SysPost extends BaseEntity {
    /**
     * 主键
     */
    private Long postId;

    /**
     * 岗位名称
     */
    private String postName;

    /**
     * 岗位编码
     */
    private String postCode;

    /**
     * 显示顺序
     */
    private Integer orderNum;

}
