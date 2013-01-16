package com.facebook.orca.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.concurrent.Semaphore;

class MmsSendMessageHandler$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Uri localUri = (Uri)paramIntent.getParcelableExtra("uri");
    int i = paramIntent.getIntExtra("state", 0);
    if ((localUri != null) && (localUri.getLastPathSegment().equals(Long.valueOf(this.a))))
    {
      MmsSendMessageHandler.SendTransactionState.a(this.b, i);
      this.c.release();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.sms.MmsSendMessageHandler.1
 * JD-Core Version:    0.6.0
 */