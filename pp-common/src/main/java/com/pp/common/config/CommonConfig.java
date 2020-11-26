package com.pp.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: suntion-auth
 * @Description:
 * @Author: Shen.Sun
 * @create: 2020-11-26 13:46
 **/
@Component
@ConfigurationProperties(prefix = "pp.common")
public class CommonConfig {
    /**
     * 上传路径
     */
    private static String profile;

    public static String getProfile() {
        return profile;
    }

    public static void setProfile(String profile) {
        CommonConfig.profile = profile;
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath() {

        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath() {
        return getProfile() + "/upload";
    }
}
