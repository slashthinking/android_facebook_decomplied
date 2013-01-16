package com.facebook.katana.platform;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.facebook.common.util.Log;

public class FacebookSyncAdapterService extends Service
{
  private static final Class<?> a = FacebookSyncAdapterService.class;
  private static final boolean b = Log.a(a.getSimpleName(), 3);
  private FacebookSyncAdapterService.SyncAdapterImpl c = null;

  public IBinder onBind(Intent paramIntent)
  {
    return this.c.getSyncAdapterBinder();
  }

  public void onCreate()
  {
    this.c = new FacebookSyncAdapterService.SyncAdapterImpl(this, getApplicationContext(), new Handler());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookSyncAdapterService
 * JD-Core Version:    0.6.0
 */