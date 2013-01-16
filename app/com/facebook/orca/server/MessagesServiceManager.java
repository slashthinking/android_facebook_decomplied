package com.facebook.orca.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.app.UserActivityManager;
import com.facebook.orca.debug.BLog;

public class MessagesServiceManager
{
  private static final Class<?> a = MessagesServiceManager.class;
  private final Context b;
  private final UserActivityManager c;
  private final BroadcastReceiver d;
  private final Handler e;
  private boolean f;
  private boolean g;

  public MessagesServiceManager(Context paramContext, UserActivityManager paramUserActivityManager)
  {
    this.b = paramContext;
    this.c = paramUserActivityManager;
    this.e = new Handler();
    this.d = new MessagesServiceManager.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.facebook.app.USER_MAYBE_BECAME_ACTIVE_OR_INACTIVE");
    LocalBroadcastManager.a(paramContext).a(this.d, localIntentFilter);
  }

  private void a()
  {
    BLog.c(a, "maybeStartStopOrcaService");
    int i;
    if ((this.c.c()) || (System.currentTimeMillis() - this.c.d() < 30000L))
    {
      i = 1;
      if (i == 0)
        break label132;
      if (!this.f)
      {
        BLog.c(a, "Starting OrcaService");
        Intent localIntent2 = new Intent(this.b, MessagesService.class);
        localIntent2.setAction("Orca.START");
        this.b.startService(localIntent2);
        this.f = true;
      }
      if (!this.g)
      {
        this.e.postDelayed(new MessagesServiceManager.2(this), 30000L);
        this.g = true;
      }
    }
    while (true)
    {
      return;
      i = 0;
      break;
      label132: if (!this.f)
        continue;
      BLog.c(a, "Stopping OrcaService");
      Intent localIntent1 = new Intent(this.b, MessagesService.class);
      localIntent1.setAction("Orca.STOP");
      this.b.startService(localIntent1);
      this.f = false;
    }
  }

  private void b()
  {
    BLog.a(a, "onActivityBroadcast");
    a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.MessagesServiceManager
 * JD-Core Version:    0.6.0
 */