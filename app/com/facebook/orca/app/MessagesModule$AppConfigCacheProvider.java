package com.facebook.orca.app;

import com.facebook.orca.appconfig.AppConfigSerialization;
import com.facebook.orca.cache.AppConfigCache;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class MessagesModule$AppConfigCacheProvider extends AbstractProvider<AppConfigCache>
{
  private MessagesModule$AppConfigCacheProvider(MessagesModule paramMessagesModule)
  {
  }

  public AppConfigCache a()
  {
    return new AppConfigCache((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AppConfigSerialization)b(AppConfigSerialization.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.AppConfigCacheProvider
 * JD-Core Version:    0.6.0
 */