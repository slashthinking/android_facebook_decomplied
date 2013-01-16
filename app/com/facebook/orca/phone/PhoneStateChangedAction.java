package com.facebook.orca.phone;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.SecureBroadcastReceiver.ActionReceiver;
import com.facebook.orca.debug.BLog;

public class PhoneStateChangedAction
  implements SecureBroadcastReceiver.ActionReceiver
{
  Class<?> a = PhoneStateChangedAction.class;
  private final TelephonyState b;

  public PhoneStateChangedAction(TelephonyState paramTelephonyState)
  {
    this.b = paramTelephonyState;
  }

  public void a(Context paramContext, Intent paramIntent, BroadcastReceiverLike paramBroadcastReceiverLike)
  {
    this.b.a(paramContext);
    if (!this.b.a());
    while (true)
    {
      return;
      String str1 = paramIntent.getStringExtra("state");
      if (str1 != null)
      {
        if (str1.equals(TelephonyManager.EXTRA_STATE_RINGING))
        {
          String str2 = paramIntent.getStringExtra("incoming_number");
          this.b.a(paramContext, str2);
        }
        while (true)
        {
          this.b.a(false);
          break;
          if (str1.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
          {
            if (!this.b.c())
              continue;
            this.b.a(paramContext, this.b.d());
            continue;
          }
          if ((!str1.equals(TelephonyManager.EXTRA_STATE_IDLE)) || (!this.b.e()))
            continue;
          this.b.f();
        }
      }
      BLog.e(this.a, "Unknown call state: " + str1);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.PhoneStateChangedAction
 * JD-Core Version:    0.6.0
 */