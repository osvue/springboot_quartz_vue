package com.osvue.example.quartz.mapper;

import java.util.List;
import com.osvue.example.domain.QuartzEntity;

public interface QuartzMapper {

  List<QuartzEntity> selectList();
  
}
