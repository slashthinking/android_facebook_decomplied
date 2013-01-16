package com.facebook.orca.app;

import com.facebook.orca.appconfig.VersionChecker;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.util.VersionStringComparator;
import com.facebook.orca.config.OrcaConfig;
import com.facebook.orca.inject.AbstractProvider;

class MessagesModule$VersionCheckerProvider extends AbstractProvider<VersionChecker>
{
  private MessagesModule$VersionCheckerProvider(MessagesModule paramMessagesModule)
  {
  }

  public VersionChecker a()
  {
    return new VersionChecker((DataCache)b(DataCache.class), (OrcaConfig)b(OrcaConfig.class), (VersionStringComparator)b(VersionStringComparator.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.MessagesModule.VersionCheckerProvider
 * JD-Core Version:    0.6.0
 */