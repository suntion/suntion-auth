package com.pp.auth.model;

import com.pp.common.base.BaseEntity;
import lombok.Data;

/**
 * sys_config 参数配置表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Data
public class SysConfig extends BaseEntity {

    /**
     * 主键
     */
    private Integer configId;

    /**
     * 配置名称
     */
    private String configName;

    /**
     * 配置标识
     */
    private String configKey;

    /**
     * 配置值
     */
    private String configValue;

    /**
     * 是否系统内置 0否 1是
     */
    private String configType;
}
