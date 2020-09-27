package com.osvue.example.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByte {

 
      public static void main(String[] args) {
          // 复制文件的起始时间
          long s = System.currentTimeMillis();
          // 定义输入\输出流为mull
          FileInputStream fis = null;
          FileOutputStream fos = null;
          // 手动抛出异常
          try {
              // 读取文件
              fis = new FileInputStream("d:\\digui.mp4");
              // 读取完毕复制的文件
              fos = new FileOutputStream("d:\\dd.mp4");
              // 定义一个字节数组  存到数组b中
              byte[] b = new byte[1024 * 10];
              // 起始长度为0
              int len = 0;
              // while(){} 循环   一边读取 ，一边写入（复制）文件
              while ((len = fis.read(b)) != -1) {
                  fos.write(b, 0, len);
                  fos.flush();  //  文件刷新
              }
          } catch (Exception e) {
              System.out.println(e);
              throw new RuntimeException("文件复制失败");  // 手动抛除异常
              // 最终执行语句
          } finally {
              // 复制的文件不为空时  关闭释放资源
              if (fos != null) {
                  try {
                      fos.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  } finally {
                      if (fis != null) {
                          try {
                              fis.close();
                          } catch (IOException e) {
                              System.out.println(e);
                              throw new RuntimeException("文件复制失败");
                          }
                      }
                  }
              }
          }
          // 复制文件的结束时间   单位：ms 毫秒
          long e = System.currentTimeMillis();
          System.out.println(e-s);
      }
  }
