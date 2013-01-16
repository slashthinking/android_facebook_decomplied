package com.facebook.orca.push.c2dm;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;

class C2DMBroadcastReceiver$C2DMActionReceiver
  implements SecureBroadcastReceiver.ActionReceiver
{
  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    C2DMService.a(paramContext, paramIntent);
    paramBroadcastReceiverLike.setResult(-1, null, null);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMBroadcastReceiver.C2DMActionReceiver
 * JD-Core Version:    0.6.0
 */