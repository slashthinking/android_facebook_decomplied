package com.facebook.orca.sms;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.app.AppInitLockHelper;

public class MmsTransactionCompletedAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  public final void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    AppInitLockHelper.a(paramContext);
    MmsTransactionStateReceiver.a(paramContext, paramIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsTransactionCompletedAction
 * JD-Core Version:    0.6.0
 */