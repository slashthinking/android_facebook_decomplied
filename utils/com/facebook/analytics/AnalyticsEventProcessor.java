package com.facebook.analytics;

import android.content.Context;
import android.util.Pair;
import com.facebook.orca.app.AppInitLock;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Objects;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;

public class AnalyticsEventProcessor
{
  private static final Class<?> a = AnalyticsEventProcessor.class;
  private long b = -1L;
  private long c = 0L;
  private long d = 0L;
  private LinkedBlockingQueue<AnalyticsEvent> e;
  private final AnalyticsPropertyUtil f;
  private final AnalyticsStorage g;
  private final AppInitLock h;
  private final Clock i;
  private final HoneyAnalyticsPeriodicReporter j;
  private final AnalyticsDeviceUtils k;
  private final OrcaSharedPreferences l;
  private final CounterHistoricalData m;
  private boolean n = true;
  private final AnalyticsSession o;
  private final Provider<String> p;
  private long q = -1L;
  private long r = -1L;
  private int s = 0;

  public AnalyticsEventProcessor(Context paramContext, Provider<String> paramProvider, AnalyticsPropertyUtil paramAnalyticsPropertyUtil, AnalyticsDatabaseSupplier paramAnalyticsDatabaseSupplier, AnalyticsStorage paramAnalyticsStorage, HoneyAnalyticsPeriodicReporter paramHoneyAnalyticsPeriodicReporter, AnalyticsDeviceUtils paramAnalyticsDeviceUtils, OrcaSharedPreferences paramOrcaSharedPreferences, AppInitLock paramAppInitLock, Clock paramClock, CounterHistoricalData paramCounterHistoricalData)
  {
    this.p = paramProvider;
    this.f = paramAnalyticsPropertyUtil;
    this.g = paramAnalyticsStorage;
    this.h = paramAppInitLock;
    this.i = paramClock;
    this.j = paramHoneyAnalyticsPeriodicReporter;
    this.k = paramAnalyticsDeviceUtils;
    this.l = paramOrcaSharedPreferences;
    this.o = new AnalyticsSession(paramContext, paramAnalyticsPropertyUtil, paramAnalyticsDatabaseSupplier, paramAnalyticsStorage);
    this.m = paramCounterHistoricalData;
  }

  private long a()
  {
    return this.l.a(SharedPrefKeys.l, 120000L);
  }

  private HoneyClientEvent a(long paramLong1, String paramString, long paramLong2, long paramLong3, List<Pair<String, Long>> paramList)
  {
    HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("counters");
    localHoneyClientEvent.a(paramLong1);
    localHoneyClientEvent.c(paramString);
    localHoneyClientEvent.d("app");
    localHoneyClientEvent.b("from", HoneyProtocolUtils.a(paramLong2));
    localHoneyClientEvent.b("to", HoneyProtocolUtils.a(paramLong3));
    if (paramList.size() > 0)
    {
      ObjectNode localObjectNode = new ObjectNode(JsonNodeFactory.instance);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        localObjectNode.put((String)localPair.first, (Long)localPair.second);
      }
      localHoneyClientEvent.a("data", localObjectNode);
    }
    return localHoneyClientEvent;
  }

  private void a(long paramLong)
  {
    this.q = paramLong;
    this.f.b(AnalyticsDbProperties.a, paramLong);
  }

  private void a(long paramLong, String paramString)
  {
    if (paramLong - h() > 86400000L)
    {
      c(paramLong);
      c(this.k.a(paramLong, paramString));
    }
    if (paramLong - i() > a())
    {
      d(paramLong);
      c(this.k.b(paramLong, paramString));
    }
    if (paramLong - j() > 1800000L)
    {
      e(paramLong);
      a(paramLong, paramString, 24, 3600000L);
    }
  }

  private void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    long l1 = paramLong2 * (paramLong1 / paramLong2);
    for (long l2 = l1 - paramLong2 * paramInt; l2 < l1; l2 += paramLong2)
    {
      long l3 = l2 + paramLong2;
      List localList = this.m.a(l2, l3);
      if (!localList.isEmpty())
        c(a(paramLong1, paramString, l2, l3, localList));
    }
    this.m.b(0L, l1);
  }

  private boolean a(AnalyticsEvent paramAnalyticsEvent)
  {
    return paramAnalyticsEvent.a("session_timeout");
  }

  private long b()
  {
    return this.l.a(SharedPrefKeys.m, 300000L);
  }

  private void b(long paramLong)
  {
    this.r = paramLong;
    this.f.b(AnalyticsDbProperties.g, paramLong);
  }

  private boolean b(AnalyticsEvent paramAnalyticsEvent)
  {
    boolean bool = true;
    if (this.s > 50L);
    while (true)
    {
      return bool;
      if ((!paramAnalyticsEvent.a("truncate_batch")) && ((paramAnalyticsEvent.d()) || (this.i.a() - f() <= b())))
        bool = false;
    }
  }

  private void c()
  {
    this.h.b();
    this.o.f();
    if (this.o.a())
      this.o.j();
    this.s = this.g.b();
    while (true)
      try
      {
        AnalyticsEvent localAnalyticsEvent = (AnalyticsEvent)this.e.poll(43200L, TimeUnit.SECONDS);
        if (localAnalyticsEvent != null)
        {
          d(localAnalyticsEvent);
          if (this.o.d() == 0L)
            a(localAnalyticsEvent.b(), localAnalyticsEvent.c());
          if ((localAnalyticsEvent.a("connection")) && (localAnalyticsEvent.a("counters")))
            this.m.a(localAnalyticsEvent.b(), localAnalyticsEvent.b("connection"), AnalyticCounters.a(localAnalyticsEvent.b("counters")));
          c(localAnalyticsEvent);
          e(localAnalyticsEvent);
          d();
          boolean bool;
          if (localAnalyticsEvent.a("resume_upload"))
          {
            this.n = true;
            bool = false;
            if (a(localAnalyticsEvent))
            {
              this.o.j();
              e();
              if (!localAnalyticsEvent.a("stop_upload"))
                continue;
              this.n = false;
            }
          }
          else if (localAnalyticsEvent.a("resume_upload_temporary"))
          {
            bool = this.n;
            this.n = true;
            continue;
            if (b(localAnalyticsEvent))
            {
              this.o.i();
              e();
              continue;
              if (localAnalyticsEvent.a("resume_upload_temporary"))
                this.n = bool;
            }
          }
          else
          {
            bool = false;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
      }
  }

  private void c(long paramLong)
  {
    this.b = paramLong;
    this.f.b(AnalyticsDbProperties.f, paramLong);
  }

  private void c(AnalyticsEvent paramAnalyticsEvent)
  {
    this.g.a(paramAnalyticsEvent, this.o.h());
    this.o.e();
    this.o.b(paramAnalyticsEvent.b());
    BLog.b(a, paramAnalyticsEvent.e().toString());
    this.s = (1 + this.s);
  }

  private void d()
  {
    long l1 = this.i.a();
    long l2 = l1 - g();
    if ((l2 > 86400000L) || (l2 < 0L))
    {
      this.g.d();
      b(l1);
    }
  }

  private void d(long paramLong)
  {
    this.c = paramLong;
  }

  private void d(AnalyticsEvent paramAnalyticsEvent)
  {
    int i1 = 1;
    if (!this.o.a());
    while (true)
    {
      if (i1 != 0)
        this.o.a(paramAnalyticsEvent.c());
      this.o.a(paramAnalyticsEvent);
      return;
      if ((Objects.equal(paramAnalyticsEvent.c(), this.o.b())) && (!paramAnalyticsEvent.a("new_session")))
        i1 = 0;
    }
  }

  private void e()
  {
    if (this.n)
    {
      a(this.i.a());
      this.g.d();
      BLog.b(a, "Uploading analytics report");
      this.j.b();
      this.s = 0;
    }
  }

  private void e(long paramLong)
  {
    this.d = paramLong;
  }

  private void e(AnalyticsEvent paramAnalyticsEvent)
  {
    if ((!paramAnalyticsEvent.d()) && ((paramAnalyticsEvent.a("key_ui_event")) || (paramAnalyticsEvent.b() - this.o.c() > 30000L)))
    {
      this.o.a(paramAnalyticsEvent.b());
      this.o.g();
    }
  }

  private long f()
  {
    if (this.q == -1L)
      this.q = this.f.a(AnalyticsDbProperties.a, 0L);
    return this.q;
  }

  private long g()
  {
    if (this.r == -1L)
      this.r = this.f.a(AnalyticsDbProperties.g, 0L);
    return this.r;
  }

  private long h()
  {
    if (this.b == -1L)
      this.b = this.f.a(AnalyticsDbProperties.f, 0L);
    return this.b;
  }

  private long i()
  {
    return this.c;
  }

  private long j()
  {
    return this.d;
  }

  public void a(LinkedBlockingQueue<AnalyticsEvent> paramLinkedBlockingQueue)
  {
    this.e = paramLinkedBlockingQueue;
    new Thread(new AnalyticsEventProcessor.1(this), "AnalyticsEventProcessor").start();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticsEventProcessor
 * JD-Core Version:    0.6.2
 */