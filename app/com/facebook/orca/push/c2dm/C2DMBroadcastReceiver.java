package com.facebook.orca.push.c2dm;

import com.facebook.content.SecureBroadcastReceiver;
import com.google.common.collect.ImmutableMap.Builder;

public class C2DMBroadcastReceiver extends SecureBroadcastReceiver
{
  public C2DMBroadcastReceiver()
  {
    super(new ImmutableMap.Builder().b("com.google.android.c2dm.intent.RECEIVE", new C2DMBroadcastReceiver.C2DMActionReceiver(null)).b("com.google.android.c2dm.intent.REGISTRATION", new C2DMBroadcastReceiver.C2DMActionReceiver(null)).b());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.C2DMBroadcastReceiver
 * JD-Core Version:    0.6.0
 */