package com.facebook.katana.platform;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LogoutReason;
import com.facebook.katana.service.method.ApiMethod;

class FacebookSyncAdapterService$SyncAdapterImpl$3
  implements Runnable
{
  public void run()
  {
    if (FacebookSyncAdapterService.a())
      Log.e(FacebookSyncAdapterService.b(), "Cleaning up...");
    AppSession localAppSession = AppSession.a(this.a, false);
    if (localAppSession != null)
      localAppSession.b(this.b);
    Message localMessage = Message.obtain(this.c, 4);
    this.c.sendMessage(localMessage);
    if (ApiMethod.a(this.d, this.e))
      AppSession.a(this.a, FacebookSyncAdapterService.SyncAdapterImpl.a(this.f), AppSession.LogoutReason.FORCED_SYNC_ADAPTER_SERVICE_SESSION_ERROR);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookSyncAdapterService.SyncAdapterImpl.3
 * JD-Core Version:    0.6.0
 */