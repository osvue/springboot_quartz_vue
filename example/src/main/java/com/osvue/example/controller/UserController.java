package com.osvue.example.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.osvue.example.common.ResultBean;
import com.osvue.example.domain.Menu;
import com.osvue.example.domain.MenuExample;
import com.osvue.example.domain.PePermissionApiExtend;
import com.osvue.example.domain.User;
import com.osvue.example.mapper.MenuMapper;
import com.osvue.example.mapper.UserMapper;
import com.osvue.example.service.IPePermissionApiExtendService;

@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MenuMapper menuMapper;
  
  @Resource
  IPePermissionApiExtendService pePerservice;

  @RequestMapping("/page")
  public ResultBean<List<User>> getAllUser() {

    return new ResultBean<List<User>>(userMapper.selectByExample(null));
  }

  @RequestMapping("/city")
  public ResultBean<List<Menu>> getAllCity() {

    MenuExample example = new MenuExample();
    // example.createCriteria().andNameLike();
    return new ResultBean<List<Menu>>(menuMapper.selectByExample(example));
  }

  @RequestMapping(value = "mirrors")
  public ResultBean<PageInfo<PePermissionApiExtend>> getPePermissionApiExtendList(
      @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

    PageInfo<PePermissionApiExtend> pi = pePerservice.getPePermissionApiExtendList(pageNo, pageSize);
    return new ResultBean<>(pi);
  }

}
