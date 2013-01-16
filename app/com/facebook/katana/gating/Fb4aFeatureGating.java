package com.facebook.katana.gating;

import android.content.Context;
import com.facebook.appcenter.prefs.AppCenterPrefKeys;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.common.util.LocationUtils;
import com.facebook.orca.prefs.OrcaSharedPreferences;

@Deprecated
public class Fb4aFeatureGating
{
  private final Context a;
  private final OrcaSharedPreferences b;

  public Fb4aFeatureGating(Context paramContext, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramContext;
    this.b = paramOrcaSharedPreferences;
  }

  public boolean a()
  {
    boolean bool = this.b.a(FbandroidPrefKeys.h, false);
    int i = 0;
    if (!bool)
      i = 1;
    return i;
  }

  public boolean b()
  {
    boolean bool1 = a();
    boolean bool2 = false;
    if (!bool1);
    while (true)
    {
      return bool2;
      bool2 = this.b.a(FeedPrefKeys.o, false);
    }
  }

  public boolean c()
  {
    if (Boolean.TRUE.equals(Gatekeeper.a(this.a, "fbandroid_native_app_center_2")));
    for (boolean bool = true; ; bool = this.b.a(AppCenterPrefKeys.b, false))
      return bool;
  }

  public boolean d()
  {
    return f();
  }

  public boolean e()
  {
    return Boolean.TRUE.equals(Gatekeeper.a(this.a, "stale_client_notification"));
  }

  public boolean f()
  {
    return LocationUtils.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.gating.Fb4aFeatureGating
 * JD-Core Version:    0.6.0
 */