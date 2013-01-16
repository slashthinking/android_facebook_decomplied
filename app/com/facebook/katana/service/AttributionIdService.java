package com.facebook.katana.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.common.util.ErrorReporting;
import com.facebook.device_id.UniqueIdForDeviceHolder;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.service.method.AttributionIdUpdate;
import com.facebook.orca.app.AppInitLockHelper;
import com.facebook.orca.inject.FbInjector;

public class AttributionIdService extends Service
{
  private AppSession a;
  private AppSessionListener b;

  private void a(String paramString1, String paramString2, long paramLong)
  {
    Context localContext = getApplicationContext();
    AppInitLockHelper.a(localContext);
    String str = ((UniqueIdForDeviceHolder)FbInjector.a(localContext).a(UniqueIdForDeviceHolder.class)).b();
    if (str == null)
    {
      ErrorReporting.a("uniqueIdForDevice null", "AttributionIdUpdate get uniqueIdForDevice null");
      stopSelf();
    }
    while (true)
    {
      return;
      if (this.a != null)
      {
        this.a.a(this.b);
        AttributionIdUpdate localAttributionIdUpdate = new AttributionIdUpdate(localContext, paramString2, paramString1, str, paramLong);
        this.a.a(localContext, localAttributionIdUpdate, 1001, 1020, null);
        continue;
      }
      stopSelf();
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onDestroy()
  {
    if ((this.a != null) && (this.b != null))
      this.a.b(this.b);
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent != null)
    {
      this.a = AppSession.b(getApplicationContext(), false);
      this.b = new AttributionIdService.1(this);
      a(paramIntent.getStringExtra("attribution_id_name"), paramIntent.getStringExtra("auth_token"), paramIntent.getLongExtra("user_id", 0L));
    }
    return 2;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.AttributionIdService
 * JD-Core Version:    0.6.0
 */