package com.pp.auth.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * sys_user_post 用户岗位表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Setter
@Getter
@Accessors(chain = true)
public class SysUserPost {
    /**
     * 岗位ID
     */
    private Long postId;

    /**
     * 用户ID
     */
    private Long userId;

}
