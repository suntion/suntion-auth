package com.pp.test;


import com.pp.quartz.utils.QuartzContants;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.LoggerFactory;

/**
 *
 * @Author scott
 * @Data 2019/7/1821:32
 **/
@DisallowConcurrentExecution
public class TestJob implements Job {
    private final static org.slf4j.Logger Logger = LoggerFactory.getLogger(TestJob.class);


    @Override
    public void execute(JobExecutionContext context) {
        String jobName = context.getJobDetail().getJobClass().getName();
        String paramStr = context.getMergedJobDataMap().getString(QuartzContants.JOBDETAIL_DATAMAP_KEY);
        Logger.info("Job '{}' executed. param '{}'.", jobName, paramStr);
    }
}
