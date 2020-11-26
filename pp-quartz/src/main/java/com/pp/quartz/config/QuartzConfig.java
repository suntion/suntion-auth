package com.pp.quartz.config;


import com.pp.quartz.AutowiredSpringBeanJobFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

/**
 * @author Suntion
 */
@Configuration
@EnableScheduling
public class QuartzConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init() {
        logger.info("【Quartz 模块启动】");
    }

    @Bean
    public AutowiredSpringBeanJobFactory autowiredSpringBeanJobFactory() {
        return new AutowiredSpringBeanJobFactory();
    }
}
