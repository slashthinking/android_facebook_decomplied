package com.facebook.orca.push.c2dm;

import android.app.AlarmManager;
import android.content.Context;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.annotations.MeUserId;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.net.OrcaNetworkManager;
import com.facebook.orca.ops.OrcaServiceOperation;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class C2DMPushModule$FacebookPushServerRegistrarProvider extends AbstractProvider<FacebookPushServerRegistrar>
{
  private C2DMPushModule$FacebookPushServerRegistrarProvider(C2DMPushModule paramC2DMPushModule)
  {
  }

  public FacebookPushServerRegistrar a()
  {
    return new FacebookPushServerRegistrar((Context)b(Context.class, FromApplication.class), a(OrcaServiceOperation.class, FromApplication.class), a(SingleMethodRunner.class), (UnregisterPushTokenMethod)b(UnregisterPushTokenMethod.class), a(String.class, MeUserId.class), (UniqueIdForDeviceHolder)b(UniqueIdForDeviceHolder.class), (OrcaNetworkManager)b(OrcaNetworkManager.class), (PushTokenHolder)b(PushTokenHolder.class), (AnalyticsLogger)b(AnalyticsLogger.class), (AlarmManager)b(AlarmManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMPushModule.FacebookPushServerRegistrarProvider
 * JD-Core Version:    0.6.0
 */