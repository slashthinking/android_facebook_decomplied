package com.facebook.analytics;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.facebook.analytics.feature.FeatureStatusReporter;
import com.facebook.base.BuildConstants;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.net.OrcaNetworkManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AnalyticsDeviceUtils
{
  private static final ImmutableMap<Integer, String> i = new ImmutableMap.Builder().b(Integer.valueOf(7), "1xRTT").b(Integer.valueOf(4), "CDMA").b(Integer.valueOf(2), "EDGE").b(Integer.valueOf(14), "EHPRD").b(Integer.valueOf(5), "EVDO 0").b(Integer.valueOf(6), "EVDO A").b(Integer.valueOf(12), "EVDO B").b(Integer.valueOf(1), "GPRS").b(Integer.valueOf(8), "HSDPA").b(Integer.valueOf(10), "HSPA").b(Integer.valueOf(15), "HSPAP").b(Integer.valueOf(9), "HSUPA").b(Integer.valueOf(11), "IDEN").b(Integer.valueOf(13), "LTE").b(Integer.valueOf(3), "UMTS").b(Integer.valueOf(0), "UNKNOWN").b();
  private static final ImmutableMap<Integer, String> j = new ImmutableMap.Builder().b(Integer.valueOf(2), "CDMA").b(Integer.valueOf(1), "GSM").b(Integer.valueOf(0), "NONE").b(Integer.valueOf(3), "SIP").b();
  private Context a;
  private final TelephonyManager b;
  private final PackageManager c;
  private final OrcaNetworkManager d;
  private final AnalyticCounters e;
  private final Set<FeatureStatusReporter> f;
  private long g;
  private long h;

  public AnalyticsDeviceUtils(Context paramContext, TelephonyManager paramTelephonyManager, PackageManager paramPackageManager, OrcaNetworkManager paramOrcaNetworkManager, AnalyticCounters paramAnalyticCounters, Set<FeatureStatusReporter> paramSet)
  {
    this.a = paramContext;
    this.b = paramTelephonyManager;
    this.c = paramPackageManager;
    this.d = paramOrcaNetworkManager;
    this.e = paramAnalyticCounters;
    this.f = ImmutableSet.a(paramSet);
    this.g = 0L;
    this.h = 0L;
    b();
  }

  private double a()
  {
    double d1 = -1.0D;
    Intent localIntent = this.a.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (localIntent != null)
    {
      int k = localIntent.getIntExtra("level", -1);
      double d2 = localIntent.getIntExtra("scale", -1);
      if ((k >= 0) && (d2 > 0.0D))
        d1 = k / d2;
    }
    return d1;
  }

  public static ObjectNode a(Context paramContext)
  {
    Map localMap = PreferenceManager.getDefaultSharedPreferences(paramContext).getAll();
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localObjectNode.put((String)localEntry.getKey(), localEntry.getValue().toString());
    }
    return localObjectNode;
  }

  private static String a(int paramInt)
  {
    String str = (String)j.get(Integer.valueOf(paramInt));
    if (str == null)
      str = (String)j.get(Integer.valueOf(0));
    return str;
  }

  private void a(HoneyClientEvent paramHoneyClientEvent, String paramString, NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo != null)
    {
      String str1 = paramNetworkInfo.getTypeName();
      String str2 = paramString + "connection";
      if (StringUtil.a(str1))
        str1 = "none";
      paramHoneyClientEvent.b(str2, str1);
      String str3 = paramNetworkInfo.getSubtypeName();
      if (!StringUtil.a(str3))
        paramHoneyClientEvent.b(paramString + "connection_subtype", str3);
    }
  }

  private static String b(int paramInt)
  {
    String str = (String)i.get(Integer.valueOf(paramInt));
    if (str == null)
      str = (String)i.get(Integer.valueOf(0));
    return str;
  }

  private void b()
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      int k = Process.myUid();
      long l1 = TrafficStats.getUidRxBytes(k);
      if (l1 != -1L)
        this.g = l1;
      long l2 = TrafficStats.getUidTxBytes(k);
      if (l2 != -1L)
        this.h = l2;
    }
  }

  private void b(HoneyClientEvent paramHoneyClientEvent)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    ActivityManager localActivityManager = (ActivityManager)this.a.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    Debug.MemoryInfo localMemoryInfo1 = new Debug.MemoryInfo();
    Debug.getMemoryInfo(localMemoryInfo1);
    int k = localActivityManager.getMemoryClass();
    int m = (int)(100.0F * ((localMemoryInfo1.nativePrivateDirty + localMemoryInfo1.dalvikPrivateDirty) / (1024.0F * k)));
    int n = (int)(100 * localMemoryInfo1.nativePrivateDirty / (1024.0F * k));
    int i1 = (int)(100 * (localMemoryInfo1.nativePrivateDirty + localMemoryInfo1.dalvikPrivateDirty + localMemoryInfo1.otherPrivateDirty) / (1024.0F * k));
    int i2 = (int)(100 * localMemoryInfo1.otherPrivateDirty / (1024.0F * k));
    int i3 = (int)((float)(100L * localMemoryInfo.threshold) / (float)localMemoryInfo.availMem);
    localObjectNode.put("pct_dirty_dalvik_native", m);
    localObjectNode.put("pct_dirty_native", n);
    localObjectNode.put("pct_dirty_dalvik_native_other", i1);
    localObjectNode.put("pct_dirty_other", i2);
    localObjectNode.put("mem_available", localMemoryInfo.availMem);
    localObjectNode.put("mem_threshold", localMemoryInfo.threshold);
    localObjectNode.put("mem_is_low", localMemoryInfo.lowMemory);
    localObjectNode.put("mem_pct_total", i3);
    localObjectNode.put("mem_class", k);
    localObjectNode.put("debug_kb_private_dalvik", localMemoryInfo1.dalvikPrivateDirty);
    localObjectNode.put("debug_kb_proportional_dalvik", localMemoryInfo1.dalvikPss);
    localObjectNode.put("debug_kb_shared_dalvik", localMemoryInfo1.dalvikSharedDirty);
    localObjectNode.put("debug_kb_private_native", localMemoryInfo1.nativePrivateDirty);
    localObjectNode.put("debug_kb_proportional_native", localMemoryInfo1.nativePss);
    localObjectNode.put("debug_kb_shared_native", localMemoryInfo1.nativeSharedDirty);
    localObjectNode.put("debug_kb_private_other", localMemoryInfo1.otherPrivateDirty);
    localObjectNode.put("debug_kb_proportional_other", localMemoryInfo1.otherPss);
    localObjectNode.put("debug_kb_shared_other", localMemoryInfo1.otherSharedDirty);
    localObjectNode.put("gc_total_count", Debug.getGlobalGcInvocationCount());
    localObjectNode.put("gc_freed_size", Debug.getGlobalFreedSize());
    localObjectNode.put("gc_freed_count", Debug.getGlobalFreedCount());
    localObjectNode.put("native_heap_size", Debug.getNativeHeapSize());
    localObjectNode.put("native_heap_allocated", Debug.getNativeHeapAllocatedSize());
    localObjectNode.put("native_heap_free", Debug.getNativeHeapFreeSize());
    localObjectNode.put("thread_alloc_count", Debug.getThreadAllocCount());
    localObjectNode.put("thread_alloc_size", Debug.getThreadAllocSize());
    paramHoneyClientEvent.a("memory_info", localObjectNode);
  }

  private void c()
  {
    long l1 = -1L;
    long l2 = this.g;
    long l3 = this.h;
    b();
    long l4 = this.g - l2;
    if ((l4 < 0L) || (l4 > 524288000L))
      l4 = l1;
    long l5 = this.h - l3;
    if ((l5 < 0L) || (l5 > 524288000L));
    while (true)
    {
      this.e.b("total_bytes_received", l4);
      this.e.b("total_bytes_sent", l1);
      return;
      l1 = l5;
    }
  }

  private void c(HoneyClientEvent paramHoneyClientEvent)
  {
    ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      FeatureStatusReporter localFeatureStatusReporter = (FeatureStatusReporter)localIterator.next();
      localObjectNode.put(localFeatureStatusReporter.a(), localFeatureStatusReporter.b());
    }
    paramHoneyClientEvent.a("features", localObjectNode);
  }

  public HoneyAnalyticsEvent a(long paramLong, String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("device_info");
    localHoneyClientEvent.a(paramLong);
    localHoneyClientEvent.c(paramString);
    DisplayMetrics localDisplayMetrics = this.a.getResources().getDisplayMetrics();
    localHoneyClientEvent.b("device_type", Build.MODEL);
    localHoneyClientEvent.b("brand", Build.BRAND);
    localHoneyClientEvent.b("manufacturer", Build.MANUFACTURER);
    localHoneyClientEvent.b("os_type", "Android");
    localHoneyClientEvent.b("os_ver", Build.VERSION.RELEASE);
    localHoneyClientEvent.a("density", localDisplayMetrics.density);
    localHoneyClientEvent.a("screen_width", localDisplayMetrics.widthPixels);
    localHoneyClientEvent.a("screen_height", localDisplayMetrics.heightPixels);
    localHoneyClientEvent.a("front_camera", this.c.hasSystemFeature("android.hardware.camera.front"));
    localHoneyClientEvent.a("rear_camera", this.c.hasSystemFeature("android.hardware.camera"));
    localHoneyClientEvent.b("allows_non_market_installs", Settings.Secure.getString(this.a.getContentResolver(), "install_non_market_apps"));
    localHoneyClientEvent.b("android_id", Settings.Secure.getString(this.a.getContentResolver(), "android_id"));
    localHoneyClientEvent.a("preferences", a(this.a));
    localHoneyClientEvent.d("device");
    return localHoneyClientEvent;
  }

  public HoneyClientEvent a(HoneyClientEvent paramHoneyClientEvent, long paramLong, String paramString)
  {
    paramHoneyClientEvent.a(paramLong);
    paramHoneyClientEvent.c(paramString);
    a(paramHoneyClientEvent);
    paramHoneyClientEvent.b("carrier", this.b.getNetworkOperatorName());
    paramHoneyClientEvent.b("carrier_country_iso", this.b.getNetworkCountryIso());
    paramHoneyClientEvent.b("network_type", b(this.b.getNetworkType()));
    paramHoneyClientEvent.b("phone_type", a(this.b.getPhoneType()));
    paramHoneyClientEvent.b("locale", this.a.getResources().getConfiguration().locale.toString());
    paramHoneyClientEvent.b("sim_country_iso", this.b.getSimCountryIso());
    if (this.b.getSimState() == 5)
      paramHoneyClientEvent.b("sim_operator", this.b.getSimOperatorName());
    paramHoneyClientEvent.a("battery", a());
    Runtime localRuntime = Runtime.getRuntime();
    long l1 = localRuntime.maxMemory();
    paramHoneyClientEvent.a("free_mem", (l1 - (localRuntime.totalMemory() - localRuntime.freeMemory())) / 1048576L);
    paramHoneyClientEvent.a("total_mem", l1 / 1048576L);
    paramHoneyClientEvent.a("core_count", localRuntime.availableProcessors());
    long l2 = -1L;
    long l3 = -1L;
    try
    {
      StatFs localStatFs1 = new StatFs(Environment.getDataDirectory().getPath());
      l2 = localStatFs1.getAvailableBlocks() * localStatFs1.getBlockSize();
      long l9 = localStatFs1.getBlockCount();
      int i1 = localStatFs1.getBlockSize();
      l3 = l9 * i1;
      label289: paramHoneyClientEvent.a("device_free_space", l2 / 1048576L);
      paramHoneyClientEvent.a("device_total_space", l3 / 1048576L);
      long l4 = -1L;
      long l5 = -1L;
      try
      {
        StatFs localStatFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
        l4 = localStatFs2.getAvailableBlocks() * localStatFs2.getBlockSize();
        long l8 = localStatFs2.getBlockSize();
        int n = localStatFs2.getBlockCount();
        l5 = l8 * n;
        label380: paramHoneyClientEvent.a("sd_free_space", l4 / 1048576L);
        paramHoneyClientEvent.a("sd_total_space", l5 / 1048576L);
        long l6 = -1L;
        try
        {
          for (File localFile : new File(this.a.getFilesDir().getParentFile().getPath() + "/databases").listFiles())
            if (localFile.isFile())
            {
              long l7 = localFile.length();
              l6 += l7;
            }
        }
        catch (Exception localException3)
        {
          paramHoneyClientEvent.a("db_folder_size", l6 / 1048576.0D);
          a(this.d.c(), paramHoneyClientEvent);
          c(paramHoneyClientEvent);
          return paramHoneyClientEvent;
        }
      }
      catch (Exception localException2)
      {
        break label380;
      }
    }
    catch (Exception localException1)
    {
      break label289;
    }
  }

  public String a(NetworkInfo paramNetworkInfo)
  {
    String str;
    if ((paramNetworkInfo == null) || (StringUtil.a(paramNetworkInfo.getTypeName())))
      str = "unknown";
    while (true)
    {
      return str;
      if (StringUtil.a(paramNetworkInfo.getSubtypeName()))
        str = paramNetworkInfo.getTypeName();
      else
        str = paramNetworkInfo.getTypeName() + "." + paramNetworkInfo.getSubtypeName().replace('.', '_').replace(' ', '_');
    }
  }

  public void a(NetworkInfo paramNetworkInfo, HoneyClientEvent paramHoneyClientEvent)
  {
    c();
    this.e.a(paramHoneyClientEvent);
    paramHoneyClientEvent.a("connection", a(paramNetworkInfo));
    paramHoneyClientEvent.a("counters", this.e.b().toString());
    this.e.a();
  }

  public void a(HoneyClientEvent paramHoneyClientEvent)
  {
    a(paramHoneyClientEvent, "", this.d.c());
  }

  public void a(HoneyClientEvent paramHoneyClientEvent, NetworkInfo paramNetworkInfo)
  {
    a(paramHoneyClientEvent, "previous_", paramNetworkInfo);
  }

  public boolean a(NetworkInfo paramNetworkInfo1, NetworkInfo paramNetworkInfo2)
  {
    boolean bool = true;
    if (paramNetworkInfo1 == null)
      if (paramNetworkInfo2 != null);
    while (true)
    {
      return bool;
      bool = false;
      continue;
      if (paramNetworkInfo2 == null)
        bool = false;
      else if ((paramNetworkInfo1.getType() != paramNetworkInfo2.getType()) || (paramNetworkInfo1.getSubtype() != paramNetworkInfo2.getSubtype()))
        bool = false;
    }
  }

  public HoneyAnalyticsEvent b(long paramLong, String paramString)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("device_status");
    a(localHoneyClientEvent, paramLong, paramString);
    localHoneyClientEvent.d("device");
    if (BuildConstants.a())
      b(localHoneyClientEvent);
    return localHoneyClientEvent;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsDeviceUtils
 * JD-Core Version:    0.6.2
 */