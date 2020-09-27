package com.osvue.example.utils;

import java.util.List;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
* @Author: Mr.Han
* @Description: quartz-vue
* @Date: Created in 2020/6/9_11:01
* @Modified By: THE GIFTED
*/
public class JsonUtil {


  // 定义jackson对象
  private static final ObjectMapper MAPPER = new ObjectMapper();






  /**
   *
   * @title objectToJson
   * @description TODO(objectToJson)
   * @param data
   * @return
   */
  public static String objectToJson(Object data) {
    try {
      String string = MAPPER.writeValueAsString(data);
      return string;
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   *
   * @title jsonToPojo
   * @description TODO(将json结果集转化为对象)
   * @param jsonData
   * @param beanType
   * @return
   */
  public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
    try {
      T t = MAPPER.readValue(jsonData, beanType);
      return t;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }


  /**
   *
   * @title jsonToList
   * @description TODO(将json数据转换成pojo对象list)
   * @param jsonData
   * @param beanType
   * @return
   */
  public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
    JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    try {
      List<T> list = MAPPER.readValue(jsonData, javaType);
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    }


    return null;
  }


}