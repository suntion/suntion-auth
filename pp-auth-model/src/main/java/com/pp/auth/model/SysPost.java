package com.pp.auth.model;

import com.pp.common.base.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_post 岗位
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
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
