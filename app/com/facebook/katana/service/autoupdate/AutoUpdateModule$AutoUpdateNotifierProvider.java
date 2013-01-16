package com.facebook.katana.service.autoupdate;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.config.AppBuildInfo;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class AutoUpdateModule$AutoUpdateNotifierProvider extends AbstractProvider<AutoUpdateNotifier>
{
  private AutoUpdateModule$AutoUpdateNotifierProvider(AutoUpdateModule paramAutoUpdateModule)
  {
  }

  public AutoUpdateNotifier a()
  {
    return new AutoUpdateNotifier((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AppBuildInfo)b(AppBuildInfo.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateModule.AutoUpdateNotifierProvider
 * JD-Core Version:    0.6.0
 */