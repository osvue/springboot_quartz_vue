package com.osvue.example.aspect;

import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy // 这个可以不加
public class NodeAspect {


  // 声明切面
  public static final String POINTCUT1 =
      "execution(* com.osvue.example.controller.NodeController.*(..))";

  // @Pointcut(POINTCUT1)
  // public void mycut(){
  //
  // }
  //

  // @Before(POINTCUT1)
  public void before() {
    System.out.println("zhixing");
  }

  // @After(POINTCUT1)
  public void after() {
    System.out.println("执行后------------");
  }

  @Around(POINTCUT1)
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    // before();
    Object[] args = pjp.getArgs();
    Arrays.asList(args).stream().forEach(System.out::println);

    Object result = pjp.proceed();
    System.out.println(result.toString());
    after();
    return result;
  }

  @AfterThrowing(value = POINTCUT1, throwing = "tw")
  public void exp(Throwable tw) {
    System.out.println("出现异常:" + tw.getMessage());
  }

}