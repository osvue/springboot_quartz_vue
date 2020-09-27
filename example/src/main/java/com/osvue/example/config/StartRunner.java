package com.osvue.example.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Mr.Han
 * @Description: example
 * @Date: Created in 2020/8/4_15:11
 * @Modified By: THE GIFTED
 */
@Component
public class StartRunner implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {


    loadSysParams();
  }
  public void loadSysParams(){
    System.out.println("【  SYSTEM-MONITOR】Loading...");
    System.out.println("   /$$$$$$   /$$$$$$$ /$$    /$$ /$$   /$$  /$$$$$$   ");
    System.out.println("  /$$__  $$ /$$_____/|  $$  /$$/| $$  | $$ /$$__  $$  ");
    System.out.println(" | $$  \\ $$|  $$$$$$  \\  $$/$$/ | $$  | $$| $$$$$$$$  ");
    System.out.println(" | $$  | $$ \\____  $$  \\  $$$/  | $$  | $$| $$_____/  ");
    System.out.println(" |  $$$$$$/ /$$$$$$$/   \\  $/   |  $$$$$$/|  $$$$$$$  ");
    System.out.println("  \\______/ |_______/     \\_/     \\______/  \\_______/  ");
    System.out.println("【  SYSTEM-MONITOR】Load SUCCESS...");
  }
}
 