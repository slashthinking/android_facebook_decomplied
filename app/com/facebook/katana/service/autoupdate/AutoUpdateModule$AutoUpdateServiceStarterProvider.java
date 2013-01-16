package com.facebook.katana.service.autoupdate;

import android.app.AlarmManager;
import android.content.Context;
import com.facebook.common.util.ProcessUtil;
import com.facebook.config.AppBuildInfo;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class AutoUpdateModule$AutoUpdateServiceStarterProvider extends AbstractProvider<AutoUpdateServiceStarter>
{
  private AutoUpdateModule$AutoUpdateServiceStarterProvider(AutoUpdateModule paramAutoUpdateModule)
  {
  }

  public AutoUpdateServiceStarter a()
  {
    return new AutoUpdateServiceStarter((AlarmManager)b(AlarmManager.class), (AppBuildInfo)b(AppBuildInfo.class), "fb4a_new", (Context)b(Context.class), (Clock)b(Clock.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (ProcessUtil)b(ProcessUtil.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.autoupdate.AutoUpdateModule.AutoUpdateServiceStarterProvider
 * JD-Core Version:    0.6.0
 */