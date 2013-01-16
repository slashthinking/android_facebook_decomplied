package com.facebook.orca.login;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class OrcaAuthStateMachineMonitor extends AuthStateMachineMonitor
{
  public OrcaAuthStateMachineMonitor(LocalBroadcastManager paramLocalBroadcastManager)
  {
    super(paramLocalBroadcastManager);
  }

  public void d()
  {
    this.a.a(new Intent("com.facebook.orca.login.OrcaAuthStateMachineMonitor.LOGIN_COMPLETE"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.OrcaAuthStateMachineMonitor
 * JD-Core Version:    0.6.0
 */