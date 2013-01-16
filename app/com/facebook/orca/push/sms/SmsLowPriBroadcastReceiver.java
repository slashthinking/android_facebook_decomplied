package com.facebook.orca.push.sms;

import com.facebook.content.SecureBroadcastReceiver;

public class SmsLowPriBroadcastReceiver extends SecureBroadcastReceiver
{
  public SmsLowPriBroadcastReceiver()
  {
    super("android.provider.Telephony.SMS_RECEIVED", new SmsLowPriReceivedAction());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.sms.SmsLowPriBroadcastReceiver
 * JD-Core Version:    0.6.0
 */