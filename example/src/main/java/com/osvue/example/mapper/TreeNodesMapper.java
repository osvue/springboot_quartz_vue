package com.osvue.example.mapper;

import com.osvue.example.domain.TreeNodes;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Mr.Han
 * @Description: example
 * @Date: Created in 2020/8/19_15:33
 * @Modified By: THE GIFTED
 */
public interface TreeNodesMapper {

  @Select(value = "select id , name , PARENT_ID as parentId  from pf_bus_org limit 1,1000")
  List<TreeNodes> getAll();
}
