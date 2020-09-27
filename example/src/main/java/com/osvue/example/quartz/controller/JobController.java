package com.osvue.example.quartz.controller;

import javax.servlet.http.HttpServletResponse;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.osvue.example.common.ResultBean;
import com.osvue.example.domain.QuartzEntity;
import com.osvue.example.quartz.service.IQuartzService;
import io.netty.handler.codec.http.HttpContentEncoder.Result;

@RestController
@RequestMapping("/job")
public class JobController {

  private final static Logger LOGGER = LoggerFactory.getLogger(JobController.class);

  @Autowired
  private Scheduler scheduler;
  @Autowired
  private IQuartzService jobService;

  @PostMapping("/add")
  public ResultBean<Object> save(@RequestBody QuartzEntity quartz) {
    LOGGER.info("新增任务");
    try {
      jobService.save(quartz);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultBean<>(e);
    }
    return new ResultBean<>("success");
  }

  @RequestMapping(value = "/list")
  public ResultBean<PageInfo<QuartzEntity>> list(@RequestBody QuartzEntity quartz,
      @RequestParam(required = false, defaultValue = "1") Integer pageNo,
      @RequestParam(required = false, defaultValue = "10") Integer pageSize)
      throws SchedulerException {
    LOGGER.info("任务列表");
    PageInfo<QuartzEntity> pi = jobService.get(quartz, pageNo, pageSize);
    return new ResultBean<>(pi);
  }

  @PostMapping("/trigger")
  public ResultBean<Object> trigger(@RequestBody QuartzEntity quartz, HttpServletResponse response) {
    LOGGER.info("触发任务");
    try {
      JobKey key = new JobKey(quartz.getJobName(), quartz.getJobGroup());
      scheduler.triggerJob(key);
    } catch (SchedulerException e) {
      e.printStackTrace();
      return new ResultBean<>(e);
    }
    return new ResultBean<>();
  }

  @PostMapping("/pause")
  public ResultBean pause(@RequestBody QuartzEntity quartz, HttpServletResponse response) {
    LOGGER.info("停止任务");
    try {
      JobKey key = new JobKey(quartz.getJobName(), quartz.getJobGroup());
      scheduler.pauseJob(key);
    } catch (SchedulerException e) {
      e.printStackTrace();
      return new ResultBean<>(e);
    }
    return new ResultBean<>();
  }

  @PostMapping("/resume")
  public ResultBean<Object> resume(@RequestBody QuartzEntity quartz, HttpServletResponse response) {
    LOGGER.info("恢复任务");
    try {
      JobKey key = new JobKey(quartz.getJobName(), quartz.getJobGroup());
      scheduler.resumeJob(key);
    } catch (SchedulerException e) {
      e.printStackTrace();
      return new ResultBean<>(e);
    }
    return new ResultBean<>();
  }

  @PostMapping("/remove")
  public ResultBean<Object> remove(QuartzEntity quartz, HttpServletResponse response) {
    LOGGER.info("移除任务");
    try {
      TriggerKey triggerKey = TriggerKey.triggerKey(quartz.getJobName(), quartz.getJobGroup());
      // 停止触发器
      scheduler.pauseTrigger(triggerKey);
      // 移除触发器
      scheduler.unscheduleJob(triggerKey);
      // 删除任务
      scheduler.deleteJob(JobKey.jobKey(quartz.getJobName(), quartz.getJobGroup()));
      System.out.println("removeJob:" + JobKey.jobKey(quartz.getJobName()));
    } catch (Exception e) {
      e.printStackTrace();
      return new ResultBean<>(e.getMessage());
    }
    return new ResultBean<>();
  }
}
