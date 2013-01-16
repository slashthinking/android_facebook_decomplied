package com.facebook.katana.platform;

import android.content.Context;
import android.content.SyncResult;
import android.os.Handler;
import android.os.Message;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSession.LogoutReason;

class FacebookSyncAdapterService$SyncAdapterImpl$2
  implements Runnable
{
  public void run()
  {
    AppSession localAppSession = AppSession.a(this.a, false);
    if (localAppSession == null)
    {
      Log.b(FacebookSyncAdapterService.b(), "Cannot sync due to missing active session");
      this.b.stats.numAuthExceptions = 1L;
      AppSession.a(this.e.a, FacebookSyncAdapterService.SyncAdapterImpl.a(this.e), AppSession.LogoutReason.FORCED_SYNC_ADAPTER_SERVICE_SESSION_ERROR);
    }
    while (true)
    {
      Message localMessage = Message.obtain(this.d, 2);
      this.d.sendMessage(localMessage);
      return;
      localAppSession.a(this.c);
      localAppSession.e(this.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookSyncAdapterService.SyncAdapterImpl.2
 * JD-Core Version:    0.6.0
 */