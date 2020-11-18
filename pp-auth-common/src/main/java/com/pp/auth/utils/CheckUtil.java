package com.pp.auth.utils;


/**
 * 验证类
 *
 * @author suns suntion@yeah.net
 * @since 2017年11月24日上午9:54:18
 */
public class CheckUtil {
    private CheckUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean paramNotNullException(Object obj) {
        if (obj == null || "".equals(obj.toString().trim())) {
            return true;
        } else {
            throw new IllegalArgumentException("param is not ");
        }
    }


    public static boolean isEmpty(Object obj) {
        if (obj == null || "".equals(obj.toString().trim())) {
            return true;
        }
        return false;
    }

    public static boolean isEmptyWithException(Object obj, String nullMsg) {
        if (obj == null || "".equals(obj.toString().trim())) {
            throw new IllegalArgumentException(nullMsg);
        } else {
            return false;
        }
    }


    public static boolean isNotEmpty(Object obj) {
        if (obj == null || "".equals(obj.toString().trim())) {
            return false;
        }
        return true;
    }

}
