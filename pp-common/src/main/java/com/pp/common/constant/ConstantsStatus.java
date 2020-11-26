package com.pp.common.constant;

/**
 * @author Bob
 * @version V1.0
 * @date 4/26/2020
 * 通用的状态
 */
public class ConstantsStatus {

    private ConstantsStatus() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 无效
     */
    public static final String DISABLE = "0";

    /**
     * 有效
     */
    public static final String ENABLE = "1";


}
