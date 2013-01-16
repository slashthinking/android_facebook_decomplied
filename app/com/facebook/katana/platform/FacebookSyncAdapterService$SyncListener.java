package com.facebook.katana.platform;

import android.os.Handler;
import android.os.Message;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;

final class FacebookSyncAdapterService$SyncListener extends AppSessionListener
{
  public int a;
  public Exception b;
  private Handler c;

  public void a(Handler paramHandler)
  {
    this.c = paramHandler;
  }

  public void a(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    this.a = paramInt;
    this.b = paramException;
    Message localMessage = Message.obtain(this.c, 3);
    this.c.sendMessage(localMessage);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.platform.FacebookSyncAdapterService.SyncListener
 * JD-Core Version:    0.6.0
 */