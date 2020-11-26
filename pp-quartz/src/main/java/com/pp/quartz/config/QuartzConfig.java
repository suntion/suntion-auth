package com.pp.quartz.config;


import com.pp.quartz.AutowiredSpringBeanJobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Suntion
 */
@Configuration
@EnableScheduling
@EnableConfigurationProperties(QuartzProperties.class)
@ConditionalOnProperty(
        prefix = "pp.quartz",
        name = "open",
        havingValue = "true"
)
public class QuartzConfig {
    @Autowired
    QuartzProperties quartzProperties;

    @Bean
    public AutowiredSpringBeanJobFactory autowiredSpringBeanJobFactory() {
        return new AutowiredSpringBeanJobFactory();
    }
}
