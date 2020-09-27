package com.osvue.example.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.IOUtils;
//
//* //这里我们就应该想到，用户可能直接传如File类型，也可能直接传入FileInputStream类型， //我们应该都需要支持，而不需要用户自己做类型的处理！
//* //在结合上一点的使用父类，把FileInputStream改成父类InputStream，我们最终的方法组如下：
public class FileUtil {

  private static final String DEFAULT_CHARSET = "UTF-8";

  public static List<String> readFile2List(String filename) throws IOException {
    return readFile2List(filename, DEFAULT_CHARSET);
  }

  public static List<String> readFile2List(String filename, String charset) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(filename);
    return readFile2List(fileInputStream, charset);
  }

  public static List<String> readFile2List(File file) throws IOException {
    return readFile2List(file, DEFAULT_CHARSET);
  }

  public static List<String> readFile2List(File file, String charset) throws IOException {
    FileInputStream fileInputStream = new FileInputStream(file);
    return readFile2List(fileInputStream, charset);
  }

  public static List<String> readFile2List(InputStream fileInputStream) throws IOException {
    return readFile2List(fileInputStream, DEFAULT_CHARSET);
  }

  public static List<String> readFile2List(InputStream inputStream, String charset)
      throws IOException {
    List<String> list = new ArrayList<String>();

    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(inputStream, charset));

      String s = null;
      while ((s = br.readLine()) != null) {
        list.add(s);
      }
    } finally {
      IOUtils.closeQuietly(br);
    }

    return list;
  }

}/*
  * //1 public static List<String> readFile2List(String filename) throws IOException { List<String>
  * list = new ArrayList<String>(); File file = new File(filename); FileInputStream fileInputStream
  * = new FileInputStream(file); BufferedReader br = new BufferedReader(new
  * InputStreamReader(fileInputStream, "UTF-8"));
  * 
  * // XXX操作 return list; } //2 //我们先实现，实现完之后我们做第一个修改，很明显，
  * //utf-8格式是很可能要改的，所以我们先把它做为参数提取出去，方法一拆为二，就变成这样。
  * 
  * public static List<String> readFile2List(String filename) throws IOException { return
  * readFile2List(filename, "UTF-8"); }
  * 
  * public static List<String> readFile2List(String filename, String charset) throws IOException {
  * List<String> list = new ArrayList<String>();
  * 
  * File file = new File(filename); FileInputStream fileInputStream = new FileInputStream(file);
  * 
  * BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, charset));
  * 
  * // XXX操作
  * 
  * return list; }
  * 
  * //333333333333 //多了一个方法，直接调用之前的方法主体，主要的代码还是只有一份，之前的调用地方不需要做任何修改！可以放心修改。
  * 
  * //然后我们在看里面的实现，下面这2行代码里面，String类型的filename会变化为File类型， //然后在变化为FileInputStream 类型之后才使用。
  * 
  * File file = new File(filename); FileInputStream fileInputStream = new FileInputStream(file);
  * 
  */


