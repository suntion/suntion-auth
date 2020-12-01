package com.pp.log.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @program: suntion-auth
 * @Description: 日志自动注入
 * @Author: Shen.Sun  suntion@yeah.net
 * @create: 2020-12-01 17:18
 **/
@Configuration
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnProperty(
        prefix = "pp.log",
        name = "open",
        havingValue = "true"
)
public class LogAutoConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init() {
        logger.info("【Log 模块启动】");
    }


    @Autowired
    private LogProperties logProperties;

    @Bean(name = "logDatasource")
    @ConditionalOnProperty(name = "pp.log.type",havingValue = "mysql")
    public DataSource logDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "logJdbcTemplate")
    @ConfigurationProperties(prefix = "pp.log.datasource")
    @ConditionalOnProperty(name = "pp.log.type",havingValue = "mysql")
    public JdbcTemplate logJdbcTemplate(@Qualifier("logDatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
