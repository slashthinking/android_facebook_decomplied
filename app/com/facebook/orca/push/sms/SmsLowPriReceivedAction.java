package com.facebook.orca.push.sms;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.annotations.IsClientSmsEnabled;
import com.facebook.orca.annotations.IsSmsNotifyEnabled;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.nux.OrcaNuxManager;

public class SmsLowPriReceivedAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  public final void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    boolean bool1 = ((Boolean)localFbInjector.a(Boolean.class, IsSmsNotifyEnabled.class)).booleanValue();
    boolean bool2 = ((Boolean)localFbInjector.a(Boolean.class, IsClientSmsEnabled.class)).booleanValue();
    OrcaNuxManager localOrcaNuxManager = (OrcaNuxManager)localFbInjector.a(OrcaNuxManager.class);
    if ((bool2) && (!bool1) && (localOrcaNuxManager.f()))
      SmsReceiver.a(paramContext, paramIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.SmsLowPriReceivedAction
 * JD-Core Version:    0.6.0
 */