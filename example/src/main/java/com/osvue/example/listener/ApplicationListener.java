package com.osvue.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext context = sce.getServletContext();

    String cxf = context.getContextPath();
    context.setAttribute("ctx", cxf);
    System.out.println("---------------ServletContext初始化成功  ctx被加入到作用域--------" + cxf);
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

  }
}
