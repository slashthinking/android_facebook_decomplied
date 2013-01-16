package com.facebook.orca.protocol.methods;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class SendViaChatHandler$MyPublishListener$1 extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.facebook.orca.push.mqtt.PUBLISH"))
    {
      String str1 = paramIntent.getStringExtra("topic_name");
      String str2 = paramIntent.getStringExtra("payload");
      this.a.a(str1, str2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.protocol.methods.SendViaChatHandler.MyPublishListener.1
 * JD-Core Version:    0.6.0
 */