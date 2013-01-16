package com.facebook.orca.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.Semaphore;

class SmsSendMessageHandler$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SmsSendMessageHandler.SendResultCode.a(this.a, getResultCode());
    this.b.release();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.SmsSendMessageHandler.1
 * JD-Core Version:    0.6.0
 */