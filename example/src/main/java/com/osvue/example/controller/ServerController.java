package com.osvue.example.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.osvue.example.common.ResultBean;
import com.osvue.example.domain.Server;
import com.osvue.example.server.service.IMonitorService;

/**
 * 服务器监控
 *
 *  @author hzqq110@163.com
 */
@Controller
public class ServerController {
  @Resource
  private   IMonitorService serverService;

  @GetMapping(value = "/server")
  public String server(ModelMap mmap) throws Exception {
    Server server = new Server();
    server.copyTo();
    mmap.put("server", server);
    return "server";
  }


  
  @ResponseBody
  @RequestMapping(value = "/monitor/server")
  public ResultBean<Map<String, Object>> defaultSocket() {
    Map<String, Object> map = serverService.getServers();
    return new ResultBean<>(map);
  }


  @RequestMapping(value = "/in")
  public String defaultUrl() {
    return "index";
  }
  @RequestMapping(value = "/tree")
  public String defaultIndexUrl() {
    return "tree";
  }
}
