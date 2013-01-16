package com.facebook.hardware;

import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.facebook.orca.common.util.Clock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.List;

public class CellDiagnosticsSerializer
{
  private final TelephonyManager a;
  private final Clock b;

  public CellDiagnosticsSerializer(TelephonyManager paramTelephonyManager, Clock paramClock)
  {
    this.a = paramTelephonyManager;
    this.b = paramClock;
  }

  private ArrayNode a(List<NeighboringCellInfo> paramList)
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
        NeighboringCellInfo localNeighboringCellInfo = (NeighboringCellInfo)localIterator.next();
        ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
        localObjectNode.put("network_type", a(localNeighboringCellInfo.getNetworkType()));
        int i = localNeighboringCellInfo.getCid();
        int j = localNeighboringCellInfo.getLac();
        int k = localNeighboringCellInfo.getPsc();
        int m = localNeighboringCellInfo.getRssi();
        if (i != -1)
          localObjectNode.put("cid", i);
        if (j != -1)
          localObjectNode.put("lac", j);
        if (k != -1)
          localObjectNode.put("psc", k);
        if (m != 99)
          localObjectNode.put("rssi", m);
        localArrayNode.add(localObjectNode);
      }
    }
  }

  private ObjectNode a(TelephonyManager paramTelephonyManager, CdmaCellLocation paramCdmaCellLocation)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    if (paramCdmaCellLocation != null)
    {
      int i = paramCdmaCellLocation.getBaseStationId();
      int j = paramCdmaCellLocation.getBaseStationLatitude();
      int k = paramCdmaCellLocation.getBaseStationLongitude();
      int m = paramCdmaCellLocation.getNetworkId();
      int n = paramCdmaCellLocation.getSystemId();
      if (i != -1)
        localObjectNode.put("cdma_base_station_id", i);
      if (j != 2147483647)
        localObjectNode.put("cdma_base_station_latitude", j);
      if (k != 2147483647)
        localObjectNode.put("cdma_base_station_longitude", k);
      if (m != -1)
        localObjectNode.put("cdma_network_id", m);
      if (n != -1)
        localObjectNode.put("cdma_system_id", n);
    }
    return localObjectNode;
  }

  private ObjectNode a(TelephonyManager paramTelephonyManager, GsmCellLocation paramGsmCellLocation)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("network_country_iso", paramTelephonyManager.getNetworkCountryIso());
    localObjectNode.put("network_operator_mcc_mnc", paramTelephonyManager.getNetworkOperator());
    localObjectNode.put("network_operator_name", paramTelephonyManager.getNetworkOperatorName());
    localObjectNode.put("is_network_roaming", paramTelephonyManager.isNetworkRoaming());
    int i;
    int j;
    if (paramGsmCellLocation != null)
    {
      i = paramGsmCellLocation.getCid();
      j = paramGsmCellLocation.getLac();
      if (Build.VERSION.SDK_INT < 9)
        break label132;
    }
    label132: for (int k = paramGsmCellLocation.getPsc(); ; k = -1)
    {
      if (i != -1)
        localObjectNode.put("gsm_cid", i);
      if (j != -1)
        localObjectNode.put("gsm_lac", j);
      if (k != -1)
        localObjectNode.put("gsm_psc", k);
      return localObjectNode;
    }
  }

  private String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "UNKNOWN";
    case 7:
    case 4:
    case 2:
    case 14:
    case 5:
    case 6:
    case 12:
    case 1:
    case 8:
    case 10:
    case 15:
    case 9:
    case 11:
    case 13:
    case 3:
    }
    while (true)
    {
      return str;
      str = "1xRTT";
      continue;
      str = "CDMA";
      continue;
      str = "EDGE";
      continue;
      str = "EHRPD";
      continue;
      str = "EVDO_0";
      continue;
      str = "EVDO_A";
      continue;
      str = "EVDO_B";
      continue;
      str = "GPRS";
      continue;
      str = "HSDPA";
      continue;
      str = "HSPA";
      continue;
      str = "HSPAP";
      continue;
      str = "HSUPA";
      continue;
      str = "IDEN";
      continue;
      str = "LTE";
      continue;
      str = "UMTS";
    }
  }

  private String b(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default:
      str = "UNKNOWN";
    case 2:
    case 1:
    case 3:
    case 0:
    }
    while (true)
    {
      return str;
      str = "CDMA";
      continue;
      str = "GSM";
      continue;
      str = "SIP";
      continue;
      str = "NONE";
    }
  }

  public JsonNode a()
  {
    Object localObject;
    if (this.a == null)
    {
      localObject = null;
      return localObject;
    }
    ObjectNode localObjectNode1 = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode1.put("network_type", a(this.a.getNetworkType()));
    localObjectNode1.put("phone_type", b(this.a.getPhoneType()));
    localObjectNode1.put("sim_country_iso", this.a.getSimCountryIso());
    localObjectNode1.put("sim_operator_mcc_mnc", this.a.getSimOperator());
    localObjectNode1.put("sim_operator_name", this.a.getSimOperatorName());
    localObjectNode1.put("has_icc_card", this.a.hasIccCard());
    localObjectNode1.put("timestamp", this.b.a());
    CellLocation localCellLocation = this.a.getCellLocation();
    if ((localCellLocation instanceof CdmaCellLocation))
    {
      ObjectNode localObjectNode3 = a(this.a, (CdmaCellLocation)localCellLocation);
      if (localObjectNode3 != null)
        localObjectNode1.putAll(localObjectNode3);
    }
    while (true)
    {
      ArrayNode localArrayNode = a(this.a.getNeighboringCellInfo());
      if (localArrayNode != null)
        localObjectNode1.put("neighbor_cell_info", localArrayNode);
      localObject = localObjectNode1;
      break;
      if (!(localCellLocation instanceof GsmCellLocation))
        continue;
      ObjectNode localObjectNode2 = a(this.a, (GsmCellLocation)localCellLocation);
      if (localObjectNode2 == null)
        continue;
      localObjectNode1.putAll(localObjectNode2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.hardware.CellDiagnosticsSerializer
 * JD-Core Version:    0.6.0
 */