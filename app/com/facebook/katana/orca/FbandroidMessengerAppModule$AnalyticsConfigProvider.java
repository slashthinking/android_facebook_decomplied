package com.facebook.katana.orca;

import com.facebook.analytics.AnalyticsConfig;
import com.facebook.orca.annotations.MeUser;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.users.User;

class FbandroidMessengerAppModule$AnalyticsConfigProvider extends AbstractProvider<AnalyticsConfig>
{
  private FbandroidMessengerAppModule$AnalyticsConfigProvider(FbandroidMessengerAppModule paramFbandroidMessengerAppModule)
  {
  }

  public AnalyticsConfig a()
  {
    return new FbAnalyticsConfig(FbandroidMessengerAppModule.a(this.a), a(User.class, MeUser.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidMessengerAppModule.AnalyticsConfigProvider
 * JD-Core Version:    0.6.0
 */