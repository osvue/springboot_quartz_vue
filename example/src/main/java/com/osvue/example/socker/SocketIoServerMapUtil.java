package com.osvue.example.socker;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.corundumstudio.socketio.SocketIOClient;

public class SocketIoServerMapUtil {
  public static ConcurrentMap<String, SocketIOClient> webSocketMap = new ConcurrentHashMap<>();

  public static void put(String key, SocketIOClient SocketIOClient) {
      webSocketMap.put(key, SocketIOClient);
  }

  public static SocketIOClient get(String key) {
      return webSocketMap.get(key);
  }

  public static void remove(String key) {
      webSocketMap.remove(key);
  }

  public static Collection<SocketIOClient> getValues() {
      return webSocketMap.values();
  }
  
  public static ConcurrentMap<String, SocketIOClient> getWebSocketMap() {
      return webSocketMap;
  }
}