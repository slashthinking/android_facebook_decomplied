package com.facebook.analytics;

import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.config.AppBuildInfo;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.config.PlatformAppConfig;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.List;

public class HoneyAnalyticsUploadHandler
{
  private static final Class<?> a = HoneyAnalyticsUploadHandler.class;
  private final AppBuildInfo b;
  private final PlatformAppConfig c;
  private final AnalyticsStorage d;
  private final TelephonyManager e;
  private final SingleMethodRunner f;
  private final SendAnalyticLogsMethod g;
  private final UniqueIdForDeviceHolder h;
  private final OrcaNetworkManager i;
  private final Clock j;

  public HoneyAnalyticsUploadHandler(AppBuildInfo paramAppBuildInfo, PlatformAppConfig paramPlatformAppConfig, AnalyticsStorage paramAnalyticsStorage, TelephonyManager paramTelephonyManager, UniqueIdForDeviceHolder paramUniqueIdForDeviceHolder, OrcaNetworkManager paramOrcaNetworkManager, SingleMethodRunner paramSingleMethodRunner, SendAnalyticLogsMethod paramSendAnalyticLogsMethod, Clock paramClock)
  {
    this.b = paramAppBuildInfo;
    this.c = paramPlatformAppConfig;
    this.d = paramAnalyticsStorage;
    this.e = paramTelephonyManager;
    this.f = paramSingleMethodRunner;
    this.g = paramSendAnalyticLogsMethod;
    this.i = paramOrcaNetworkManager;
    this.h = paramUniqueIdForDeviceHolder;
    this.j = paramClock;
  }

  private String a(AnalyticsStorage.EventBatchInfo paramEventBatchInfo)
  {
    String str1 = this.d.b(paramEventBatchInfo.a);
    String str4;
    if (TextUtils.isEmpty(str1))
    {
      str4 = null;
      return str4;
    }
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    localObjectNode.put("time", paramEventBatchInfo.c);
    localObjectNode.put("app_id", this.c.b());
    localObjectNode.put("app_ver", this.b.a());
    localObjectNode.put("device_id", this.h.b());
    localObjectNode.put("session_id", paramEventBatchInfo.b);
    localObjectNode.put("seq", paramEventBatchInfo.d);
    if (paramEventBatchInfo.e != null)
      localObjectNode.put("uid", paramEventBatchInfo.e);
    String str2 = this.e.getNetworkOperatorName();
    if (TextUtils.isEmpty(str2))
      str2 = "n/a";
    localObjectNode.put("carrier", str2);
    localObjectNode.put("device", Build.MODEL);
    localObjectNode.put("os_ver", Build.VERSION.RELEASE);
    localObjectNode.put("build_num", this.b.b());
    NetworkInfo localNetworkInfo = this.i.c();
    if (localNetworkInfo != null);
    for (String str3 = localNetworkInfo.getTypeName(); ; str3 = "none")
    {
      localObjectNode.put("conn", str3);
      localObjectNode.put("sent_time", HoneyProtocolUtils.a(this.j.a()));
      localObjectNode.put("data", new HoneyAnalyticsUploadHandler.RawJsonBlobNode(this, "[" + str1 + "]"));
      str4 = localObjectNode.toString();
      break;
    }
  }

  public void a()
  {
    if (!this.i.b());
    while (true)
    {
      return;
      long l = SystemClock.elapsedRealtime();
      Iterator localIterator = this.d.c().iterator();
      label28: AnalyticsStorage.EventBatchInfo localEventBatchInfo;
      String str;
      while (localIterator.hasNext())
      {
        localEventBatchInfo = (AnalyticsStorage.EventBatchInfo)localIterator.next();
        str = a(localEventBatchInfo);
        if (str != null)
          break label76;
        this.d.a(localEventBatchInfo.a);
      }
      continue;
      try
      {
        label76: if (((Boolean)this.f.a(this.g, str)).booleanValue())
          this.d.a(localEventBatchInfo.a);
        if (SystemClock.elapsedRealtime() - l <= 120000L)
          break label28;
      }
      catch (Exception localException)
      {
        while (true)
          BLog.b(a, "error upload analytic logs", localException);
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.HoneyAnalyticsUploadHandler
 * JD-Core Version:    0.6.2
 */