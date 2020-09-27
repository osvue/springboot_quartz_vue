package com.osvue.example.server.service;

import java.util.Map;

public interface IMonitorService {


  /**
   * 查询数据分页
   * 
   * @return Map<String,Object>
   */
  Map<String, Object> getServers();
}

