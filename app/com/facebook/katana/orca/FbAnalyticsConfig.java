package com.facebook.katana.orca;

import android.content.Context;
import com.facebook.analytics.AnalyticsConfig;
import com.facebook.analytics.AnalyticsConfig.Level;
import com.facebook.base.BuildConstants;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.orca.users.User;
import javax.inject.Provider;

public class FbAnalyticsConfig
  implements AnalyticsConfig
{
  private final Provider<User> a;
  private final Context b;

  public FbAnalyticsConfig(Context paramContext, Provider<User> paramProvider)
  {
    this.a = paramProvider;
    this.b = paramContext;
  }

  private boolean b()
  {
    Boolean localBoolean = Gatekeeper.a(this.b, "fbandroid_detailed_analytics");
    if (localBoolean == null);
    for (boolean bool = false; ; bool = localBoolean.booleanValue())
      return bool;
  }

  private Boolean c()
  {
    Boolean localBoolean = Gatekeeper.a(this.b, "fbandroid_analytics");
    if (localBoolean == null)
      localBoolean = Boolean.valueOf(true);
    return localBoolean;
  }

  public AnalyticsConfig.Level a()
  {
    AnalyticsConfig.Level localLevel;
    if ((User)this.a.b() == null)
      localLevel = AnalyticsConfig.Level.UNSET;
    while (true)
    {
      return localLevel;
      if ((BuildConstants.a()) || (b()))
      {
        localLevel = AnalyticsConfig.Level.CORE_AND_SAMPLED;
        continue;
      }
      if (!c().booleanValue())
      {
        localLevel = AnalyticsConfig.Level.NONE;
        continue;
      }
      localLevel = AnalyticsConfig.Level.CORE;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbAnalyticsConfig
 * JD-Core Version:    0.6.0
 */