package com.facebook.orca.push.c2dm;

import android.app.AlarmManager;
import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.push.annotations.IsGcmEnabled;

class C2DMPushModule$C2DMRegistrarProvider extends AbstractProvider<C2DMRegistrar>
{
  private C2DMPushModule$C2DMRegistrarProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public C2DMRegistrar a()
  {
    return new C2DMRegistrar((Context)b(Context.class, FromApplication.class), (OrcaSharedPreferences)b(OrcaSharedPreferences.class), (AnalyticsLogger)b(AnalyticsLogger.class), ((Boolean)b(Boolean.class, IsGcmEnabled.class)).booleanValue(), (OrcaNetworkManager)b(OrcaNetworkManager.class), (FacebookPushServerRegistrar)b(FacebookPushServerRegistrar.class), (PushTokenHolder)b(PushTokenHolder.class), (AlarmManager)b(AlarmManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.C2DMRegistrarProvider
 * JD-Core Version:    0.6.0
 */