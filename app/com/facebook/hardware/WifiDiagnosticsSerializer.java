package com.facebook.hardware;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.List;

public class WifiDiagnosticsSerializer
{
  private final WifiManager a;

  public WifiDiagnosticsSerializer(WifiManager paramWifiManager)
  {
    this.a = paramWifiManager;
  }

  private JsonNode a(WifiInfo paramWifiInfo)
  {
    ObjectNode localObjectNode = null;
    if (paramWifiInfo == null);
    while (true)
    {
      return localObjectNode;
      String str = paramWifiInfo.getBSSID();
      localObjectNode = null;
      if (str == null)
        continue;
      localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      localObjectNode.put("mac_address", str);
      localObjectNode.put("is_hidden_ssid", paramWifiInfo.getHiddenSSID());
      localObjectNode.put("link_speed_mbps", paramWifiInfo.getLinkSpeed());
      localObjectNode.put("signal_strength", paramWifiInfo.getRssi());
      localObjectNode.put("ssid", paramWifiInfo.getSSID());
    }
  }

  private JsonNode a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()));
    ArrayNode localArrayNode;
    for (Object localObject = null; ; localObject = localArrayNode)
    {
      return localObject;
      localArrayNode = new ArrayNode(JsonNodeFactory.instance);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ScanResult localScanResult = (ScanResult)localIterator.next();
        ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
        localObjectNode.put("mac_address", localScanResult.BSSID);
        localObjectNode.put("ssid", localScanResult.SSID);
        localObjectNode.put("signal_strength", localScanResult.level);
        localObjectNode.put("frequency", localScanResult.frequency);
        localObjectNode.put("capabilities", localScanResult.capabilities);
        localArrayNode.add(localObjectNode);
      }
    }
  }

  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "unknown";
    case 1:
    case 0:
    case 3:
    case 2:
    }
    while (true)
    {
      return str;
      str = "disabled";
      continue;
      str = "disabling";
      continue;
      str = "enabled";
      continue;
      str = "enabling";
    }
  }

  public JsonNode a()
  {
    ObjectNode localObjectNode;
    if (this.a == null)
      localObjectNode = null;
    while (true)
    {
      return localObjectNode;
      localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      boolean bool = this.a.isWifiEnabled();
      int i = this.a.getWifiState();
      List localList = this.a.getScanResults();
      WifiInfo localWifiInfo = this.a.getConnectionInfo();
      JsonNode localJsonNode1 = a(localList);
      JsonNode localJsonNode2 = a(localWifiInfo);
      localObjectNode.put("enabled", bool);
      localObjectNode.put("state", a(i));
      if (localJsonNode1 != null)
        localObjectNode.put("access_points", localJsonNode1);
      if (localJsonNode2 == null)
        continue;
      localObjectNode.put("current_connection", localJsonNode2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.hardware.WifiDiagnosticsSerializer
 * JD-Core Version:    0.6.0
 */