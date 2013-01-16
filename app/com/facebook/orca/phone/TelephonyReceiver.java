package com.facebook.orca.phone;

import com.facebook.content.SecureBroadcastReceiver;
import com.google.common.collect.ImmutableMap.Builder;

public class TelephonyReceiver extends SecureBroadcastReceiver
{
  public TelephonyReceiver()
  {
    super(new ImmutableMap.Builder().b("android.intent.action.PHONE_STATE", new PhoneStateChangedAction(new TelephonyState())).b("android.intent.action.NEW_OUTGOING_CALL", new OutgoingCallAction(new TelephonyState())).b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.phone.TelephonyReceiver
 * JD-Core Version:    0.6.0
 */