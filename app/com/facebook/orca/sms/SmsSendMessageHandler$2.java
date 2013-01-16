package com.facebook.orca.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SmsSendMessageHandler$2 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = getResultCode();
    SmsSendMessageHandler.a(this.b).a(this.a, i);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.SmsSendMessageHandler.2
 * JD-Core Version:    0.6.0
 */