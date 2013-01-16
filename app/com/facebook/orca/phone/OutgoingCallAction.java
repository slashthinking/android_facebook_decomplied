package com.facebook.orca.phone;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;

public class OutgoingCallAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  private final TelephonyState a;

  public OutgoingCallAction(TelephonyState paramTelephonyState)
  {
    this.a = paramTelephonyState;
  }

  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    this.a.a(paramContext);
    if ((this.a.a()) && (this.a.b()))
    {
      this.a.a(true);
      this.a.a(paramIntent.getStringExtra("android.intent.extra.PHONE_NUMBER"));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.OutgoingCallAction
 * JD-Core Version:    0.6.0
 */