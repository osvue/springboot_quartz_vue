package com.osvue.example.controller;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author THE GIFTED
 *
 */
@RestController
public class UploadController {


  @PostMapping("/upload")
  public Map<String, Object> uploadFile(MultipartFile file, HttpServletRequest req) {

    Map<String, Object> map = new HashMap<>();

    String fileName = file.getOriginalFilename();
    String realPath = req.getServletContext().getRealPath("/");
    System.out.println(realPath + "real");
    // 创建文件夹
    File foder = new File(realPath + "aacc");
    if (!foder.exists()) {
      foder.mkdirs();
    }
    String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));

    try {
      file.transferTo(new File(foder, newFileName));
    } catch (IllegalStateException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    map.put("fileName", newFileName);
    map.put("filePath", realPath + "aacc");
    map.put("msg", "SUCCESS");
    map.put("CODE", HttpServletResponse.SC_OK);
    map.put("quicefier", realPath + "aacc\\" + newFileName);
    return map;
  }


  public static void main(String[] args) {
    String fileName = "sfsafdsf.png";
    String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
    System.out.println(fileName.lastIndexOf("."));
    System.out.println(newFileName);

  }
}


