package com.facebook.orca.push.mqtt;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.orca.app.ActivityBroadcaster;

public class PushStateBroadcaster extends ActivityBroadcaster
{
  public PushStateBroadcaster(Context paramContext)
  {
    super(paramContext);
  }

  public void a(Intent paramIntent)
  {
    LocalBroadcastManager.a(this.a).a(paramIntent);
  }

  public void a(PushStateEvent paramPushStateEvent)
  {
    Intent localIntent = new Intent("com.facebook.orca.ACTION_PERSISTENT_CHANNEL_STATE_CHANGED");
    localIntent.putExtra("event", paramPushStateEvent.toValue());
    a(localIntent);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.mqtt.PushStateBroadcaster
 * JD-Core Version:    0.6.0
 */