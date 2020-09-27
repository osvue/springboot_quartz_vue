package com.osvue.example.service;

import com.github.pagehelper.PageInfo;
import com.osvue.example.domain.PePermissionApiExtend;

public interface IPePermissionApiExtendService {
  /**
   * 
   * @param pageNum 起始页, 每页显示
   * @param pageSize
   * @return
   */
  PageInfo<PePermissionApiExtend> getPePermissionApiExtendList(int pageNum,int pageSize);
}
