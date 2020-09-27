package com.osvue.example.quartz.service;

import com.github.pagehelper.PageInfo;
import com.osvue.example.domain.QuartzEntity;

public interface IQuartzService {

  PageInfo<QuartzEntity> get(QuartzEntity quartz, Integer pageNo, Integer pageSize);

  void save(QuartzEntity quartz) throws  Exception ;

 
  
//  PageInfo
  
}
