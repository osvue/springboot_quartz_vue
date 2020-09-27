package com.osvue.example.aspect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempD {
  public static void main(String[] args) {
    List<People> list = new ArrayList<>();
    list.add(new People("小明"));
    list.add(new People("小王"));
    Object[] objects1 = list.toArray();
    Object[] objects2 = list.toArray();
    System.out.println("objects1 == objects2 : "+(objects1 == objects2));
    ((People)objects1[1]).name="lusifer";
    ((People)objects2[0]).name="Range Rover";
    System.out.println("show objects1: "+ Arrays.toString(objects1));
    System.out.println("show objects2: "+ Arrays.toString(objects2));
    System.out.println("show list: "+list);
}
}
class People{
  
  String name;

  public People() {
    super();
    // TODO Auto-generated constructor stub
  }

  public People(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "People [name=" + name + "]";
  }
  
}
