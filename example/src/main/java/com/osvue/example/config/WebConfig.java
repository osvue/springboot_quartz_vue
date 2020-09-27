package com.osvue.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.osvue.example.listener.ApplicationListener;

/**
 * 注册web组件
 * 
 * @author THE GIFTED
 *
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "web")
public class WebConfig {
  private Boolean applistenerEnable = true;

  /**
   * 注册listener
   * @return
   */
  @Bean
  public ServletListenerRegistrationBean<ApplicationListener> configContextListener() {
      ServletListenerRegistrationBean<ApplicationListener> bean = new ServletListenerRegistrationBean<>();
      bean.setListener(applicationListner());
      return bean;
  }
  

  @ConditionalOnClass(value = {ApplicationListener.class})
  @Bean
  public ApplicationListener applicationListner() {
    return new ApplicationListener();
  }



  public Boolean getApplistenerEnable() {
    return applistenerEnable;
  }

  public void setApplistenerEnable(Boolean applistenerEnable) {
    this.applistenerEnable = applistenerEnable;
  }



}
