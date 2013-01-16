package com.facebook.orca.app;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

public class ActivityBroadcaster
{
  protected final Context a;

  public ActivityBroadcaster(Context paramContext)
  {
    this.a = paramContext;
  }

  public void a(Intent paramIntent)
  {
    LocalBroadcastManager.a(this.a).a(paramIntent);
  }

  public void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction(paramString);
    a(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.app.ActivityBroadcaster
 * JD-Core Version:    0.6.0
 */