package com.facebook.feed.prefs;

import com.facebook.abtest.qe.QuickExperimentManager;
import com.facebook.abtest.qe.data.QuickExperimentInfo;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.app.INeedInit;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import java.util.Map;

public class NewsFeedServerSuppliedParameters
  implements INeedInit
{
  private static final ImmutableMap<String, Long> a = ImmutableMap.a("new_data_ms", Long.valueOf(30000L), "prefetch_lit_ms", Long.valueOf(300000L), "prefetch_dark_ms", Long.valueOf(300000L));
  private final QuickExperimentManager b;
  private final FbErrorReporter c;
  private Long d = null;
  private Long e = null;
  private Long f = null;

  public NewsFeedServerSuppliedParameters(QuickExperimentManager paramQuickExperimentManager, FbErrorReporter paramFbErrorReporter)
  {
    this.b = ((QuickExperimentManager)Preconditions.checkNotNull(paramQuickExperimentManager));
    this.c = ((FbErrorReporter)Preconditions.checkNotNull(paramFbErrorReporter));
  }

  private boolean a(QuickExperimentInfo paramQuickExperimentInfo, String paramString)
  {
    if ((paramQuickExperimentInfo.e().get(paramString) == null) || (b(paramQuickExperimentInfo, paramString) != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  private Long b(QuickExperimentInfo paramQuickExperimentInfo, String paramString)
  {
    Optional localOptional = paramQuickExperimentInfo.a(paramString);
    boolean bool = localOptional.isPresent();
    Object localObject = null;
    if (bool);
    try
    {
      long l = Long.parseLong((String)localOptional.get());
      if (l > ((Long)a.get(paramString)).longValue())
      {
        Long localLong2 = Long.valueOf(l);
        localLong1 = localLong2;
        localObject = localLong1;
        return localObject;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        this.c.a("mustang_refresh_interval", paramString + " has non-numeric value " + localOptional);
        localObject = null;
        continue;
        Long localLong1 = null;
      }
    }
  }

  boolean a(QuickExperimentInfo paramQuickExperimentInfo)
  {
    if ((a(paramQuickExperimentInfo, "new_data_ms")) && (a(paramQuickExperimentInfo, "prefetch_lit_ms")) && (a(paramQuickExperimentInfo, "prefetch_dark_ms")));
    for (int i = 1; ; i = 0)
      return i;
  }

  public long b()
  {
    monitorenter;
    try
    {
      if (this.d != null)
      {
        long l2 = this.d.longValue();
        l1 = l2;
        return l1;
      }
      long l1 = 120000L;
    }
    finally
    {
      monitorexit;
    }
  }

  void b(QuickExperimentInfo paramQuickExperimentInfo)
  {
    monitorenter;
    try
    {
      this.d = b(paramQuickExperimentInfo, "new_data_ms");
      this.e = b(paramQuickExperimentInfo, "prefetch_lit_ms");
      this.f = b(paramQuickExperimentInfo, "prefetch_dark_ms");
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public long c()
  {
    monitorenter;
    try
    {
      if (this.e != null)
      {
        long l2 = this.e.longValue();
        l1 = l2;
        return l1;
      }
      long l1 = 300000L;
    }
    finally
    {
      monitorexit;
    }
  }

  public long d()
  {
    monitorenter;
    try
    {
      if (this.f != null)
      {
        long l2 = this.f.longValue();
        l1 = l2;
        return l1;
      }
      long l1 = 1800000L;
    }
    finally
    {
      monitorexit;
    }
  }

  public void i_()
  {
    Futures.a(this.b.a("mustang_refresh_interval", new NewsFeedServerSuppliedParameters.1(this)), new NewsFeedServerSuppliedParameters.2(this));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.NewsFeedServerSuppliedParameters
 * JD-Core Version:    0.6.0
 */