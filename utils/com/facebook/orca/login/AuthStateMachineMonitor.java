package com.facebook.orca.login;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class AuthStateMachineMonitor
{
  protected final LocalBroadcastManager a;

  public AuthStateMachineMonitor(LocalBroadcastManager paramLocalBroadcastManager)
  {
    this.a = paramLocalBroadcastManager;
  }

  public void a()
  {
    this.a.a(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.SHOWING_LOGIN_UI"));
  }

  public void b()
  {
    this.a.a(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.AUTH_COMPLETE"));
  }

  public void c()
  {
    this.a.a(new Intent("com.facebook.orca.login.AuthStateMachineMonitor.LOGOUT_COMPLETE"));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.AuthStateMachineMonitor
 * JD-Core Version:    0.6.2
 */