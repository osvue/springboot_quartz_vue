package com.osvue.example.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osvue.example.config.Uthread;

/** @author THE GIFTED */
@RestController
public class NodeController {

  // @Autowired
  // TreeNodesMapper treeNodesMapper;

  public static void main(String[] args) {
    String ds = "d:" + File.separator + "1907" + File.separator + "application.properties";
    File file = new File(ds);
    System.out.println(file.length());
  }


  @GetMapping(value = "/")
  public String getPath(HttpServletRequest request, Locale lo) {
    // Locale.CHINA


    String prjPath = request.getScheme() + "://" + request.getServerName()
        + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort())
        + request.getContextPath();
    request.setAttribute("cxf", prjPath);
    ServletContext servletContext = request.getServletContext();
    servletContext.setAttribute("basep", prjPath);
    return "your path is =>" + prjPath + "<<<<" + request.getServerName();
  }


  @GetMapping("/setms/{ms}")
  public String threadMsg(@PathVariable String ms, HttpServletRequest req) {
    String jsid = req.getSession().getId();

    Uthread.setMsg(ms);
    return Uthread.getMSG() + "SUCCESS" + "your thread id is the ==>"
        + Thread.currentThread().getId() + "jsessionID is ===>" + jsid;
  }


  @GetMapping("/getms")
  public String threadMsg(HttpServletRequest req) {
    String referer = req.getHeader("referer");

    return Uthread.getMSG() + "your thread id is the ==>" + referer;
  }


  /*
   * @RequestMapping(value = "/getNodes") public List<TreeNodes> getNodes() { List<TreeNodes> nodes
   * = treeNodesMapper.getAll(); List<TreeNodes> lists = nodes.stream() .filter(e ->
   * e.getParentId().equals("0")) .map( root -> { root.setNodes(getChildrens(root, nodes)); return
   * root; }) .collect(Collectors.toList()); return lists; }
   * 
   * 
   * private List<TreeNodes> getChildrens(TreeNodes root, List<TreeNodes> all) { List<TreeNodes>
   * children = all.stream() .filter( categoryEntity -> { return
   * categoryEntity.getParentId().equals(root.getId()); }) .map( categoryEntity -> {
   * categoryEntity.setNodes(getChildrens(categoryEntity, all)); return categoryEntity; })
   * .collect(Collectors.toList()); return children; }
   * 
   * 
   */
  /*
   * @RequestMapping(value = "/getNodes") public List<Node> getNodes() { List<Node> nodes =
   * createNodes(); List<Node> lists = nodes.stream().filter(e -> e.getPid() == 0).map(root -> {
   * root.setNodes(getChildrens(root, nodes)); return root; }).collect(Collectors.toList()); return
   * lists; }
   * 
   * private List<Node> createNodes() { List<Node> nodes = new ArrayList<Node>(); nodes.add(new
   * Node(1, "中国", 0)); nodes.add(new Node(2, "浙江省", 1)); nodes.add(new Node(3, "杭州市", 2));
   * nodes.add(new Node(4, "湖州市", 2)); nodes.add(new Node(5, "拱墅区", 3)); nodes.add(new Node(6,
   * "西湖区", 3)); nodes.add(new Node(7, "滨江区", 3)); nodes.add(new Node(8, "吴兴区", 4)); nodes.add(new
   * Node(9, "南浔区", 4)); nodes.add(new Node(10, "长兴县", 4));
   * 
   * nodes.add(new Node(11, "江苏省", 1)); nodes.add(new Node(12, "南京市", 11)); nodes.add(new Node(13,
   * "苏州市", 11)); nodes.add(new Node(14, "鼓楼区", 12)); nodes.add(new Node(15, "栖霞区", 12));
   * nodes.add(new Node(16, "玄武区", 12)); nodes.add(new Node(17, "金阊区", 13)); nodes.add(new Node(18,
   * "沧浪区", 13)); nodes.add(new Node(19, "平江区", 13)); return nodes; }
   * 
   * // 递归查找所有菜单的子菜单 private List<Node> getChildrens(Node root, List<Node> all) {
   * 
   * List<Node> children = all.stream().filter(categoryEntity -> { return categoryEntity.getPid() ==
   * root.getId(); }).map(categoryEntity -> { // 1、找到子菜单
   * categoryEntity.setNodes(getChildrens(categoryEntity, all)); return categoryEntity;
   * }).collect(Collectors.toList());
   * 
   * return children; }
   */

}
