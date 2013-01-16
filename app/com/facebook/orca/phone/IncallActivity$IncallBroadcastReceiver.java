package com.facebook.orca.phone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.facebook.orca.debug.BLog;
import javax.inject.Provider;

class IncallActivity$IncallBroadcastReceiver extends BroadcastReceiver
{
  private IncallActivity$IncallBroadcastReceiver(IncallActivity paramIncallActivity)
  {
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str;
    if ("android.intent.action.PHONE_STATE".equals(paramIntent.getAction()))
    {
      str = paramIntent.getStringExtra("state");
      if (str == null)
        break label140;
      if (!str.equals(TelephonyManager.EXTRA_STATE_IDLE))
        break label41;
      this.a.finish();
    }
    while (true)
    {
      return;
      label41: if (((str.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) && (((Boolean)IncallActivity.a(this.a).b()).booleanValue())) || (str.equals(TelephonyManager.EXTRA_STATE_RINGING)))
      {
        IncallActivity.b(this.a);
        continue;
      }
      if (str.equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
      {
        this.a.finish();
        continue;
      }
      BLog.e(IncallActivity.i(), "Unknown phone state: " + str);
      continue;
      label140: BLog.e(IncallActivity.i(), "Phone state was null");
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.IncallActivity.IncallBroadcastReceiver
 * JD-Core Version:    0.6.0
 */