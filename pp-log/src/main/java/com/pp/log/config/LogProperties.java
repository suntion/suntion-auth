package com.pp.log.config;


import com.pp.log.LogStoreType;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: suntion-auth
 * @Description: 日志配置
 * @Author: Shen.Sun  suntion@yeah.net
 * @create: 2020-12-01 17:20
 **/
@ConfigurationProperties(prefix = "pp.log")
public class LogProperties {
    /**
     * 是否启动存储
     */
    private Boolean open = Boolean.TRUE;

    /**
     * 日志存储类型
     */
    private LogStoreType type = LogStoreType.CONSOLE;

    public LogStoreType getType() {
        return type;
    }

    public void setType(LogStoreType type) {
        this.type = type;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
