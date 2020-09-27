package com.osvue.example.config;

public class Uthread {

  private static ThreadLocal<String> local = new ThreadLocal<>();



  public static String getMSG() {
    return local.get();
  }

  public static void setMsg(String str) {
    if (local.get() == null) {
      local.set(str);
    }
  }



}
