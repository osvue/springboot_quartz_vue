package com.osvue.example.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.List;
import lombok.Data;

/**
 * @Author: Mr.Han
 * @Description: example
 * @Date: Created in 2020/8/19_14:52
 * @Modified By: THE GIFTED
 */
@Data
 public class TreeNodes {

   private String id;
   private String name;
   private String parentId;

   List<TreeNodes> nodes;
}
 