package com.facebook.analytics;

import android.content.Context;
import android.os.Bundle;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.ops.OrcaServiceOperation.State;

public class DefaultHoneyAnalyticsPeriodicReporter
  implements HoneyAnalyticsPeriodicReporter, INeedInit
{
  private final OrcaServiceOperation a;
  private final AnalyticsConfig b;
  private final boolean c;

  public DefaultHoneyAnalyticsPeriodicReporter(Context paramContext, OrcaServiceOperation paramOrcaServiceOperation, AnalyticsConfig paramAnalyticsConfig)
  {
    this.a = paramOrcaServiceOperation;
    this.b = paramAnalyticsConfig;
    if (2147483647 * (int)Math.random() % 1 == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      paramOrcaServiceOperation.a(new DefaultHoneyAnalyticsPeriodicReporter.1(this, paramOrcaServiceOperation));
      return;
    }
  }

  public void b()
  {
    if (this.a.c() != OrcaServiceOperation.State.INIT);
    while (true)
    {
      return;
      if ((this.b.a() == AnalyticsConfig.Level.CORE) || (this.b.a() == AnalyticsConfig.Level.CORE_AND_SAMPLED) || (this.c))
        this.a.a("analytics_upload", new Bundle());
    }
  }

  public void i_()
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.DefaultHoneyAnalyticsPeriodicReporter
 * JD-Core Version:    0.6.2
 */