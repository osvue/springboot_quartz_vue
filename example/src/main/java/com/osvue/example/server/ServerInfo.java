package com.osvue.example.server;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class ServerInfo {

  public static void main(String[] args) {
    try {
      System.out.println(printlnCpuInfo());
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Map<String, String> map = printNetworkInterfaces();
    System.out.println(map);
  }

  // 获取cpu信息
  public static String printlnCpuInfo() throws InterruptedException {
    // System.out.println("----------------cpu信息----------------");
    SystemInfo systemInfo = new SystemInfo();
    CentralProcessor processor = systemInfo.getHardware().getProcessor();
    long[] prevTicks = processor.getSystemCpuLoadTicks();
    // 睡眠1s
    TimeUnit.SECONDS.sleep(1);
    long[] ticks = processor.getSystemCpuLoadTicks();
    long nice = ticks[CentralProcessor.TickType.NICE.getIndex()]
        - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
    long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()]
        - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
    long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()]
        - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
    long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()]
        - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
    long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()]
        - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
    long user = ticks[CentralProcessor.TickType.USER.getIndex()]
        - prevTicks[CentralProcessor.TickType.USER.getIndex()];
    long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()]
        - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
    long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()]
        - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
    long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
    System.out.println("----------------cpu信息----------------");
    System.out.println("cpu核数:" + processor.getLogicalProcessorCount());
    System.out.println("cpu系统使用率:" + new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
    System.out.println("cpu用户使用率:" + new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
    System.out.println("cpu当前等待率:" + new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
    System.out
        .println("cpu当前使用率:" + new DecimalFormat("#.##%").format(1.0 - (idle * 1.0 / totalCpu)));
    return new DecimalFormat("#.##%").format(1.0 - (idle * 1.0 / totalCpu));
  }

  // 获取内存使用率
  public static String MemInfo() {
    System.out.println("----------------主机内存信息----------------");
    SystemInfo systemInfo = new SystemInfo();
    GlobalMemory memory = systemInfo.getHardware().getMemory();
    // 总内存
    long totalByte = memory.getTotal();
    // 剩余
    long acaliableByte = memory.getAvailable();
    // System.out.println("总内存 = " + formatByte(totalByte));
    // System.out.println("使用" + formatByte(totalByte-acaliableByte));
    // System.out.println("剩余内存 = " + formatByte(acaliableByte));
    // System.out.println("使用率：" + new
    // DecimalFormat("#.##%").format((totalByte-acaliableByte)*1.0/totalByte));
    return new DecimalFormat("#.##%").format((totalByte - acaliableByte) * 1.0 / totalByte);
  }

  // 二进制转换
  public static String formatByte(long byteNumber) {
    // 换算单位
    double FORMAT = 1024.0;
    double kbNumber = byteNumber / FORMAT;
    if (kbNumber < FORMAT) {
      return new DecimalFormat("#.##KB").format(kbNumber);
    }
    double mbNumber = kbNumber / FORMAT;
    if (mbNumber < FORMAT) {
      return new DecimalFormat("#.##MB").format(mbNumber);
    }
    double gbNumber = mbNumber / FORMAT;
    if (gbNumber < FORMAT) {
      return new DecimalFormat("#.##GB").format(gbNumber);
    }
    double tbNumber = gbNumber / FORMAT;
    return new DecimalFormat("#.##TB").format(tbNumber);
  }

  // 获取网络上传和下载
  public static Map<String, String> printNetworkInterfaces() {
    System.out.println("Network interfaces:");
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
//    NetworkIF[] networkIFs = hal.getNetworkIFs();
    List<NetworkIF> list = hal.getNetworkIFs();
    NetworkIF[] networkIFs = list.toArray(new NetworkIF [list.size()]);
    hal.getNetworkIFs();
    int i = networkIFs.length - 1;
    NetworkIF net = networkIFs[i];

    String in = FormatUtil.formatBytes(net.getBytesRecv());
    String out = FormatUtil.formatBytes(net.getBytesSent());
    HashMap<String, String> map = new HashMap<>();
    map.put("in", in);
    map.put("out", out);
    return map;
  }

  // 获取进程数
  public static int getProcessesCount() {
    SystemInfo si = new SystemInfo();
    OperatingSystem os = si.getOperatingSystem();

    int processCount = os.getProcessCount();
    return processCount;
  }
}
