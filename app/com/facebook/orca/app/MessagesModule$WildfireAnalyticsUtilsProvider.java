package com.facebook.orca.app;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.login.WildfireAnalyticsUtils;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$WildfireAnalyticsUtilsProvider extends AbstractProvider<WildfireAnalyticsUtils>
{
  private MessagesModule$WildfireAnalyticsUtilsProvider(MessagesModule paramMessagesModule)
  {
  }

  public WildfireAnalyticsUtils a()
  {
    return new WildfireAnalyticsUtils((OrcaSharedPreferences)b(OrcaSharedPreferences.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.WildfireAnalyticsUtilsProvider
 * JD-Core Version:    0.6.0
 */