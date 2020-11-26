package com.pp.auth.model;

import com.pp.common.base.BaseEntity;
import lombok.Data;

/**
 * sys_dict_data 字典数据表
 *
 * @author Scott
 * @date   2020/11/18
 */
@Data
public class SysDictData extends BaseEntity {
    /**
     * 主键
     */
    private Long dictDataId;

    /**
     * 字典类型ID
     */
    private String dictTypeId;

    /**
     * 字典数据编码
     */
    private Integer dictCode;

    /**
     * 字典数据排序
     */
    private Integer dictSort;

    /**
     * 字典数据标签
     */
    private String dictLabel;

    /**
     * 字典数据键值
     */
    private String dictValue;

}
