package com.facebook.orca.cache;

import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.push.mqtt.MqttConnectionManager;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.FolderName;
import com.google.common.collect.Maps;
import java.util.Map;

public class ThreadsCacheUpdateRateLimiter
{
  private static final Class<?> a = ThreadsCacheUpdateRateLimiter.class;
  private final ThreadsCache b;
  private final MqttConnectionManager c;
  private final Clock d;
  private final Map<FolderName, Long> e;
  private final Map<FolderName, Long> f;
  private final Map<String, Long> g;
  private final Map<String, Long> h;

  public ThreadsCacheUpdateRateLimiter(ThreadsCache paramThreadsCache, MqttConnectionManager paramMqttConnectionManager, Clock paramClock)
  {
    this.b = paramThreadsCache;
    this.c = paramMqttConnectionManager;
    this.d = paramClock;
    this.e = Maps.a();
    this.f = Maps.a();
    this.g = Maps.a();
    this.h = Maps.a();
  }

  private long a(String paramString)
  {
    Long localLong = (Long)this.g.get(paramString);
    long l;
    if (localLong != null)
      l = localLong.longValue();
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  private long b(String paramString)
  {
    Long localLong = (Long)this.h.get(paramString);
    long l;
    if (localLong != null)
      l = localLong.longValue();
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  private long c(FolderName paramFolderName)
  {
    Long localLong = (Long)this.e.get(paramFolderName);
    long l;
    if (localLong != null)
      l = localLong.longValue();
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  private long d(FolderName paramFolderName)
  {
    Long localLong = (Long)this.f.get(paramFolderName);
    long l;
    if (localLong != null)
      l = localLong.longValue();
    while (true)
    {
      return l;
      l = -1L;
    }
  }

  ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason a(ThreadCriteria paramThreadCriteria, DataFreshnessParam paramDataFreshnessParam, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      String str;
      long l1;
      long l2;
      try
      {
        str = paramThreadCriteria.a();
        if ((str != null) && (paramDataFreshnessParam != DataFreshnessParam.DO_NOT_CHECK_SERVER) && (paramDataFreshnessParam != DataFreshnessParam.STALE_DATA_OKAY) && (paramDataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA))
          continue;
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(paramDataFreshnessParam, ThreadsCacheUpdateRateLimiter.Reason.SPECIFIC_INTENTION);
        return localDataFreshnessParamWithReason;
        l1 = this.b.e(str);
        l2 = this.d.a();
        long l3 = a(str);
        if ((l1 < this.c.i()) && (l3 < l2))
        {
          if (!paramBoolean)
            continue;
          this.g.put(str, Long.valueOf(l2 + 60000L));
          BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c of recent mqtt disconnect");
          localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.MQTT_RECENTLY_DISCONNECTED);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if ((!this.c.g()) && (l2 - l1 >= 300000L))
      {
        BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c mqtt disconnected and 5 minutes since last refresh");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED);
        continue;
      }
      long l4 = b(str);
      if ((this.c.h()) && (l1 < this.c.j()) && (l4 < l2))
      {
        if (paramBoolean)
        {
          long l5 = l2 + 60000L;
          this.h.put(str, Long.valueOf(l5));
        }
        BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c of recent mqtt connect");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.MQTT_CONNECTED);
        continue;
      }
      if (l2 - l1 >= 600000L)
      {
        BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_THREAD_DATA_THRESHOLD_MS b/c it has been 10 minutes since last thread refresh");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.OLD_DATA);
        continue;
      }
      if (!this.b.a(str, 50))
      {
        BLog.a(a, "Upgrading to PREFER_CACHE_IF_UP_TO_DATE b/c the thread is not up to date");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, ThreadsCacheUpdateRateLimiter.Reason.DATA_KNOWN_TO_BE_STALE);
        continue;
      }
      ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(paramDataFreshnessParam, ThreadsCacheUpdateRateLimiter.Reason.DEFAULT);
    }
  }

  ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason a(FolderName paramFolderName, DataFreshnessParam paramDataFreshnessParam, boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      long l1;
      long l2;
      try
      {
        if (!BLog.b(2))
          continue;
        StringBuilder localStringBuilder1 = new StringBuilder("upgradeDataFreshnessForThreadListRequest called for:");
        localStringBuilder1.append(" folder=").append(paramFolderName.b());
        if (paramDataFreshnessParam == null)
          continue;
        localStringBuilder1.append(" freshness=").append(paramDataFreshnessParam.toString());
        localStringBuilder1.append(" updateTimestamp=").append(paramBoolean);
        BLog.a(a, localStringBuilder1.toString());
        if ((paramDataFreshnessParam != DataFreshnessParam.DO_NOT_CHECK_SERVER) && (paramDataFreshnessParam != DataFreshnessParam.STALE_DATA_OKAY) && (paramDataFreshnessParam != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA))
          continue;
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(paramDataFreshnessParam, ThreadsCacheUpdateRateLimiter.Reason.SPECIFIC_INTENTION);
        return localDataFreshnessParamWithReason;
        l1 = this.d.a();
        l2 = this.b.e(paramFolderName);
        long l3 = c(paramFolderName);
        long l4 = this.c.i();
        if (!BLog.b(2))
          continue;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("upgradeDataFreshnessForThreadListRequest mqtt timestamps:");
        localStringBuilder2.append("disconnectedMqttEarliestRetryMs=").append(l3);
        localStringBuilder2.append("lastDisconnectionTimeStampMS=").append(l4);
        localStringBuilder2.append("lastUpdatedTimeMs=").append(l2);
        localStringBuilder2.append("now=").append(l1);
        BLog.a(a, localStringBuilder2.toString());
        if ((l4 > 0L) && (l2 < l4) && (l3 < l1))
        {
          if (!paramBoolean)
            continue;
          BLog.a(a, "Upgrading timestamp mDisconnectedMqttEarliestRetryMsForFolders:" + l3);
          long l7 = l1 + 60000L;
          this.e.put(paramFolderName, Long.valueOf(l7));
          BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c of recent mqtt disconnect");
          localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.MQTT_RECENTLY_DISCONNECTED);
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      if ((!this.c.g()) && (l1 - l2 >= 300000L))
      {
        BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c mqtt disconnected and 5 minutes since last refresh");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.MQTT_DISCONNECTED_AND_NOT_RECENTLY_UPDATED);
        continue;
      }
      long l5 = d(paramFolderName);
      if ((this.c.h()) && (l2 < this.c.j()) && (l5 < l1))
      {
        if (paramBoolean)
        {
          long l6 = l1 + 60000L;
          this.f.put(paramFolderName, Long.valueOf(l6));
        }
        BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c of recent mqtt connect");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.MQTT_CONNECTED);
        continue;
      }
      if (l1 - l2 >= 1800000L)
      {
        BLog.a(a, "Upgrading to CHECK_SERVER_FOR_NEW_DATA b/c 30 minutes since last refresh");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, ThreadsCacheUpdateRateLimiter.Reason.OLD_DATA);
        continue;
      }
      if (!this.b.b(paramFolderName))
      {
        BLog.a(a, "Upgrading to PREFER_CACHE_IF_UP_TO_DATE b/c cache is stale");
        localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, ThreadsCacheUpdateRateLimiter.Reason.DATA_KNOWN_TO_BE_STALE);
        continue;
      }
      ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason localDataFreshnessParamWithReason = new ThreadsCacheUpdateRateLimiter.DataFreshnessParamWithReason(paramDataFreshnessParam, ThreadsCacheUpdateRateLimiter.Reason.DEFAULT);
    }
  }

  public DataFreshnessParam a(ThreadCriteria paramThreadCriteria, DataFreshnessParam paramDataFreshnessParam)
  {
    return a(paramThreadCriteria, paramDataFreshnessParam, true).a;
  }

  public DataFreshnessParam a(FolderName paramFolderName, DataFreshnessParam paramDataFreshnessParam)
  {
    return a(paramFolderName, paramDataFreshnessParam, true).a;
  }

  public boolean a(ThreadCriteria paramThreadCriteria)
  {
    DataFreshnessParam localDataFreshnessParam = a(paramThreadCriteria, null, false).a;
    int i = 0;
    if (localDataFreshnessParam != null)
      i = 1;
    return i;
  }

  public boolean a(FolderName paramFolderName)
  {
    DataFreshnessParam localDataFreshnessParam = a(paramFolderName, null, false).a;
    int i = 0;
    if (localDataFreshnessParam != null)
      i = 1;
    return i;
  }

  public boolean b(ThreadCriteria paramThreadCriteria)
  {
    DataFreshnessParam localDataFreshnessParam1 = a(paramThreadCriteria, null, false).a;
    DataFreshnessParam localDataFreshnessParam2 = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
    int i = 0;
    if (localDataFreshnessParam1 == localDataFreshnessParam2)
      i = 1;
    return i;
  }

  public boolean b(FolderName paramFolderName)
  {
    DataFreshnessParam localDataFreshnessParam1 = a(paramFolderName, null, false).a;
    DataFreshnessParam localDataFreshnessParam2 = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
    int i = 0;
    if (localDataFreshnessParam1 == localDataFreshnessParam2)
      i = 1;
    return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ThreadsCacheUpdateRateLimiter
 * JD-Core Version:    0.6.0
 */