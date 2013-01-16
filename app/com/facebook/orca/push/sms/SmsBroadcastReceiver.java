package com.facebook.orca.push.sms;

import com.facebook.content.SecureBroadcastReceiver;

public class SmsBroadcastReceiver extends SecureBroadcastReceiver
{
  public SmsBroadcastReceiver()
  {
    super("android.provider.Telephony.SMS_RECEIVED", new SmsReceivedAction());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.SmsBroadcastReceiver
 * JD-Core Version:    0.6.0
 */