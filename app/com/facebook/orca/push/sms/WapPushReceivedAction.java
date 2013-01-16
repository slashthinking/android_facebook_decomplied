package com.facebook.orca.push.sms;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.annotations.IsSmsNotifyEnabled;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.nux.OrcaNuxManager;

class WapPushReceivedAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  public final void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    FbInjector localFbInjector = FbInjector.a(paramContext);
    boolean bool = ((Boolean)localFbInjector.a(Boolean.class, IsSmsNotifyEnabled.class)).booleanValue();
    OrcaNuxManager localOrcaNuxManager = (OrcaNuxManager)localFbInjector.a(OrcaNuxManager.class);
    if ((bool) && (localOrcaNuxManager.f()))
    {
      MmsReceiver.a(paramContext, paramIntent);
      paramBroadcastReceiverLike.setResult(-1, null, null);
      paramBroadcastReceiverLike.abortBroadcast();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.WapPushReceivedAction
 * JD-Core Version:    0.6.0
 */