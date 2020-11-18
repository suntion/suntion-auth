package com.pp.auth.model;

/**
 * sys_user_post 用户岗位表
 *
 * @author Scott
 * @date   2020/11/18
 */
public class SysUserPost {
    /**
     * 岗位ID
     */
    private Long postId;

    /**
     * 用户ID
     */
    private Long userId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
