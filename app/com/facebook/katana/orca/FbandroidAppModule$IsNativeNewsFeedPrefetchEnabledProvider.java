package com.facebook.katana.orca;

import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.feed.prefs.FeedPrefKeys;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import javax.inject.Provider;

class FbandroidAppModule$IsNativeNewsFeedPrefetchEnabledProvider extends AbstractProvider<Boolean>
{
  private OrcaSharedPreferences b = null;
  private Provider<Boolean> c = null;

  private FbandroidAppModule$IsNativeNewsFeedPrefetchEnabledProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Boolean a()
  {
    if (this.b == null)
      this.b = ((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
    if (this.c == null)
      this.c = a(Boolean.class, IsNativeNewsFeedEnabled.class);
    Boolean localBoolean;
    if (!Boolean.TRUE.equals(this.c.b()))
      localBoolean = Boolean.valueOf(false);
    while (true)
    {
      return localBoolean;
      if (Boolean.TRUE.equals(Gatekeeper.a(FbandroidAppModule.a(this.a), "android_mustang_prefetch")))
      {
        localBoolean = Boolean.valueOf(true);
        continue;
      }
      localBoolean = Boolean.valueOf(this.b.a(FeedPrefKeys.e, false));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsNativeNewsFeedPrefetchEnabledProvider
 * JD-Core Version:    0.6.0
 */