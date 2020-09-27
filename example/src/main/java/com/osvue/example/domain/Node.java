package com.osvue.example.domain;

import java.util.List;

public class Node {
  /// <summary>
  /// 编号
  /// </summary>
  public int id;

  /// <summary>
  /// 上一级编号
  /// </summary>
  public int pid;

  /// <summary>
  /// 名称
  /// </summary>
  public String text ;

  /// <summary>
  /// 子节点
  /// </summary>
  public List<Node> nodes;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<Node> getNodes() {
    return nodes;
  }

  public void setNodes(List<Node> nodes) {
    this.nodes = nodes;
  }

  @Override
  public String toString() {
    return "Node [id=" + id + ", pid=" + pid + ", text=" + text + ", nodes=" + nodes + "]";
  }

  public Node(int id, String text,int pid) {
    this.id = id;
    this.pid = pid;
    this.text = text;
    // TODO Auto-generated constructor stub
  }

  public Node() {
    super();
    // TODO Auto-generated constructor stub
  }

  public Node(int id, int pid, String text, List<Node> nodes) {
    super();
    this.id = id;
    this.pid = pid;
    this.text = text;
    this.nodes = nodes;
  }
}
