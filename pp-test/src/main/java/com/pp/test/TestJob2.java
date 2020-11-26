package com.pp.test;


import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @Author scott
 * @Data 2019/7/1821:32
 **/
@Component
public class TestJob2 {
    private final static org.slf4j.Logger Logger = LoggerFactory.getLogger(TestJob2.class);


    @Scheduled(cron = "0/2 * * * * ?")
    public void execute() {
        Logger.info("Job TestJob2 executed.");
    }
}
