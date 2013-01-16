package com.facebook.bookmark.service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.annotations.FromApplication;

public class BroadcastSender
{
  private final Context a;
  private final boolean b;
  private final LocalBroadcastManager c;

  public BroadcastSender(@FromApplication Context paramContext, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramBoolean;
    if (this.b);
    for (this.c = LocalBroadcastManager.a(this.a); ; this.c = null)
      return;
  }

  public void a(Intent paramIntent)
  {
    if (this.b)
      this.c.a(paramIntent);
    while (true)
    {
      return;
      this.a.sendBroadcast(paramIntent, "com.facebook.bookmark.broadcast.access");
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.service.BroadcastSender
 * JD-Core Version:    0.6.2
 */