package com.facebook.orca.push.sms;

import com.facebook.content.SecureBroadcastReceiver;

public class MmsBroadcastReceiver extends SecureBroadcastReceiver
{
  public MmsBroadcastReceiver()
  {
    super("android.provider.Telephony.WAP_PUSH_RECEIVED", new WapPushReceivedAction());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.MmsBroadcastReceiver
 * JD-Core Version:    0.6.0
 */