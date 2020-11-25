package com.pp.auth.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @program: tp-carhailing
 * @Description:
 * @Author: Shen.Sun
 * @create: 2020-07-21 18:00
 **/
@Configuration
@PropertySource("classpath:config.properties")
@Component
@Data
public class ConfigProperties {

//    @Value("${anda.login.url}")
//    private String andaLoginUrl;

}
