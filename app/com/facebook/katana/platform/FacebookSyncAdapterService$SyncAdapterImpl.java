package com.facebook.katana.platform;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.content.SyncStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.util.Log;
import java.io.IOException;

final class FacebookSyncAdapterService$SyncAdapterImpl extends AbstractThreadedSyncAdapter
{
  private final Handler b;
  private String c = null;

  public FacebookSyncAdapterService$SyncAdapterImpl(FacebookSyncAdapterService paramFacebookSyncAdapterService, Context paramContext, Handler paramHandler)
  {
    super(paramContext, true);
    this.b = paramHandler;
  }

  private void a(Handler paramHandler, Context paramContext, Message paramMessage, SyncResult paramSyncResult, FacebookSyncAdapterService.SyncListener paramSyncListener)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return;
      if (FacebookSyncAdapterService.a())
        Log.e(FacebookSyncAdapterService.b(), "MESSAGE_START");
      this.b.post(new FacebookSyncAdapterService.SyncAdapterImpl.2(this, paramContext, paramSyncResult, paramSyncListener, paramHandler));
      continue;
      if (FacebookSyncAdapterService.a())
        Log.e(FacebookSyncAdapterService.b(), "MESSAGE_SYNC_BEGIN");
      if (paramSyncResult.stats.numAuthExceptions <= 0L)
        continue;
      Looper.myLooper().quit();
      continue;
      int i = paramSyncListener.a;
      Exception localException = paramSyncListener.b;
      if (FacebookSyncAdapterService.a())
        Log.c(FacebookSyncAdapterService.b(), "MESSAGE_SYNC_END: error = " + i, localException);
      if (i != 200)
      {
        if (localException == null)
          break label229;
        if (!(localException instanceof IOException))
          break label217;
        paramSyncResult.stats.numIoExceptions = 1L;
      }
      while (true)
      {
        this.b.post(new FacebookSyncAdapterService.SyncAdapterImpl.3(this, paramContext, paramSyncListener, paramHandler, i, localException));
        break;
        label217: paramSyncResult.stats.numParseExceptions = 1L;
        continue;
        label229: paramSyncResult.stats.numIoExceptions = 1L;
      }
      if (FacebookSyncAdapterService.a())
        Log.e(FacebookSyncAdapterService.b(), "MESSAGE_CLEANUP_DONE");
      Looper.myLooper().quit();
    }
  }

  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    Class localClass;
    StringBuilder localStringBuilder;
    if (FacebookSyncAdapterService.a())
    {
      localClass = FacebookSyncAdapterService.b();
      localStringBuilder = new StringBuilder().append("performing sync with extras: ");
      if (paramBundle != null)
        break label120;
    }
    label120: for (String str = "null"; ; str = paramBundle.toString())
    {
      Log.e(localClass, str);
      this.c = paramAccount.name;
      Looper.prepare();
      FacebookSyncAdapterService.SyncListener localSyncListener = new FacebookSyncAdapterService.SyncListener(null);
      FacebookSyncAdapterService.SyncAdapterImpl.1 local1 = new FacebookSyncAdapterService.SyncAdapterImpl.1(this, paramSyncResult, localSyncListener);
      localSyncListener.a(local1);
      local1.sendMessage(Message.obtain(local1, 1));
      Looper.loop();
      if (FacebookSyncAdapterService.a())
        Log.e(FacebookSyncAdapterService.b(), "=====> Loop end.");
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookSyncAdapterService.SyncAdapterImpl
 * JD-Core Version:    0.6.0
 */