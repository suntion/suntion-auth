package com.pp.auth.dao;


import com.pp.auth.model.SysConfig;
import com.pp.common.base.BaseMapper;

/**
 * @author 自动生成工具
 * @date   2020/11/18
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数配置信息
     */
    public SysConfig checkConfigKeyUnique(String configKey);
}
