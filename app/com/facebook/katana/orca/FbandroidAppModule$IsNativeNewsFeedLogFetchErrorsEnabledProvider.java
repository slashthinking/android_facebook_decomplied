package com.facebook.katana.orca;

import com.facebook.feed.annotations.IsNativeNewsFeedEnabled;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.orca.inject.AbstractProvider;
import javax.inject.Provider;

class FbandroidAppModule$IsNativeNewsFeedLogFetchErrorsEnabledProvider extends AbstractProvider<Boolean>
{
  private Provider<Boolean> b = null;

  private FbandroidAppModule$IsNativeNewsFeedLogFetchErrorsEnabledProvider(FbandroidAppModule paramFbandroidAppModule)
  {
  }

  public Boolean a()
  {
    if (this.b == null)
      this.b = a(Boolean.class, IsNativeNewsFeedEnabled.class);
    if (!Boolean.TRUE.equals(this.b.b()));
    for (Boolean localBoolean = Boolean.valueOf(false); ; localBoolean = Boolean.valueOf(Boolean.TRUE.equals(Gatekeeper.a(FbandroidAppModule.a(this.a), "android_mustang_log_fetch_errors"))))
      return localBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidAppModule.IsNativeNewsFeedLogFetchErrorsEnabledProvider
 * JD-Core Version:    0.6.0
 */