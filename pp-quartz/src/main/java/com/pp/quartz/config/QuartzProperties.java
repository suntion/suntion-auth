package com.pp.quartz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: suntion-auth
 * @Description:
 * @Author: Shen.Sun
 * @create: 2020-11-26 17:50
 **/
@ConfigurationProperties(prefix = "pp.quartz")
public class QuartzProperties {
    private String driverClass;
    private String url;
    private String userName;
    private String passWord;
    private String open;

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
