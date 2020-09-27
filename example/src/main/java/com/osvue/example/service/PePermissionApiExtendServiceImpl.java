package com.osvue.example.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.osvue.example.domain.PePermissionApiExtend;
import com.osvue.example.domain.PePermissionApiExtendExample;
import com.osvue.example.mapper.PePermissionApiExtendMapper;

/**
 * 
 * @author THE GIFTED
 *
 */
@Service
public class PePermissionApiExtendServiceImpl implements IPePermissionApiExtendService {

  @Resource
  private PePermissionApiExtendMapper pePermissionApiExtendMapper;

  @Override
  public PageInfo<PePermissionApiExtend> getPePermissionApiExtendList(int pageNum, int pageSize) {

    // 分页开始
    PageHelper.startPage(pageNum, pageSize);

    PePermissionApiExtendExample example = new PePermissionApiExtendExample();
    List<PePermissionApiExtend> list = pePermissionApiExtendMapper.selectByExample(example);

    PageInfo<PePermissionApiExtend> pi = new PageInfo<>(list);
    return pi;
  }

}
