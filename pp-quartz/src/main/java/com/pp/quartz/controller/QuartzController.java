package com.pp.quartz.controller;


import com.pp.quartz.dto.QuartzJob;
import com.pp.quartz.service.QuartzService;
import com.pp.quartz.utils.QuartzContants;
import com.pp.quartz.utils.VoResult;
import com.pp.quartz.vo.JobVo;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 任务测试
 *
 * @author suns suntion@yeah.net
 * @since 2018年2月27日上午10:56:59
 */
@RestController
@RequestMapping("pp/quartz")
public class QuartzController {

    private final QuartzService quartzService;

    @Autowired
    public QuartzController(QuartzService quartzService) {
        this.quartzService = quartzService;
    }


    private QuartzJob initQuartzJob(JobVo vo) {
        QuartzJob job = new QuartzJob();
        job.setJobClass(vo.getJobClass());
        job.setJobGroup(vo.getJobGroup());
        job.setCronExpression(vo.getCronExpression());
        job.setJobDescription(vo.getJobDescription());
        job.setJobData(vo.getJobData());
        return job;
    }

    private void assertVo(JobVo vo) {
        Assert.notNull(vo.getJobClass(), "paramter jobClass must not be null");
        Assert.notNull(vo.getCronExpression(), "paramter cronExpression must not be null");
        Assert.notNull(vo.getJobGroup(), "paramter jobGroup must not be null");
        Assert.notNull(vo.getJobDescription(), "paramter jobDescription must not be null");
    }


    @PostMapping(value = "/job")
    public Object add(JobVo vo) throws SchedulerException {
        this.assertVo(vo);

        QuartzJob job = this.initQuartzJob(vo);
        job.setJobStatus(QuartzContants.JOB_STATUS_NONE);
        quartzService.createScheduleJob(job);

        return VoResult.success();
    }

    @PutMapping(value = "/job")
    public Object update(JobVo vo) throws SchedulerException {
        this.assertVo(vo);

        QuartzJob job = this.initQuartzJob(vo);
        job.setJobStatus(QuartzContants.JOB_STATUS_NONE);
        quartzService.updateScheduleJob(job);
        return VoResult.success();
    }

    @DeleteMapping(value = "/job/{jobClass}/{jobGroup}")
    public Object delete(@PathVariable("jobClass") String jobClass, @PathVariable("jobGroup") String jobGroup) throws SchedulerException {
        Assert.notNull(jobClass, "paramter jobClass must not be null");
        Assert.notNull(jobGroup, "paramter jobGroup must not be null");
        quartzService.delete(jobClass, jobGroup);
        return VoResult.success();
    }

    @PutMapping(value = "/job/pause/{jobClass}/{jobGroup}")
    public Object pause(@PathVariable("jobClass") String jobClass, @PathVariable("jobGroup") String jobGroup) throws SchedulerException {
        quartzService.pause(jobClass, jobGroup);
        return VoResult.success();
    }

    @PutMapping(value = "/job/resume/{jobClass}/{jobGroup}")
    public Object resume(@PathVariable("jobClass") String jobClass, @PathVariable("jobGroup") String jobGroup) throws SchedulerException {
        quartzService.resume(jobClass, jobGroup);
        return VoResult.success();
    }

    @PutMapping(value = "/job/runonce/{jobClass}/{jobGroup}")
    public Object runOnce(@PathVariable("jobClass") String jobClass, @PathVariable("jobGroup") String jobGroup, HttpServletRequest request) throws SchedulerException {
        String jobData = request.getParameter("jobData");
        quartzService.runOnce(jobClass, jobGroup, jobData);
        return VoResult.success();
    }

    @GetMapping(value = "/jobs")
    public Object list() throws SchedulerException {
        List<QuartzJob> list = this.quartzService.list();
        return VoResult.success(list);
    }
}
