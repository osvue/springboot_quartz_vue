package com.osvue.example.quartz.service;

import java.util.List;
import javax.annotation.Resource;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.osvue.example.domain.QuartzEntity;
import com.osvue.example.quartz.mapper.QuartzMapper;

@Service
public class QuartzServiceImpl implements IQuartzService {
  @Autowired
  private Scheduler scheduler;
  @Resource
  QuartzMapper quartzMapper;

  @Override
  public PageInfo<QuartzEntity> get(QuartzEntity quartz, Integer pageNo, Integer pageSize) {
    // TODO Auto-generated method stub
    PageHelper.startPage(pageNo, pageSize);

    List<QuartzEntity> list = quartzMapper.selectList();
    for (QuartzEntity quartzEntity : list) {
      try {
        JobKey key = new JobKey(quartzEntity.getJobName(), quartzEntity.getJobGroup());
        JobDetail jobDetail = scheduler.getJobDetail(key);
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        System.out.println(jobDataMap);
        quartzEntity.setJobMethodName(jobDataMap.getString("jobMethodName"));
      } catch (SchedulerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    PageInfo<QuartzEntity> pi = new PageInfo<QuartzEntity>(list);
    return pi;
  }

  @Override
  public void save(QuartzEntity quartz) throws  Exception {
    //如果是修改  展示旧的 任务
    if(quartz.getOldJobGroup()!=null){
        JobKey key = new JobKey(quartz.getOldJobName(),quartz.getOldJobGroup());
        scheduler.deleteJob(key);
    }
    Class cls = Class.forName(quartz.getJobClassName()) ;
    cls.newInstance();
    //构建job信息
    JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
            quartz.getJobGroup())
            .withDescription(quartz.getDescription()).build();
    job.getJobDataMap().put("jobMethodName", quartz.getJobMethodName());
    // 触发时间点
    CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
    Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(), quartz.getJobGroup())
            .startNow().withSchedule(cronScheduleBuilder).build();
    //交由Scheduler安排触发
    scheduler.scheduleJob(job, trigger);

  }

}
