package com.facebook.katana.orca;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.facebook.bookmark.BookmarkManager;
import com.facebook.katana.service.method.NotificationsGet;
import com.facebook.orca.notify.OrcaForegroundActivityListener;

public class FbandroidPushHandler
{
  private final Handler a;
  private final OrcaForegroundActivityListener b;
  private final Context c;
  private final BookmarkManager d;

  public FbandroidPushHandler(Handler paramHandler, OrcaForegroundActivityListener paramOrcaForegroundActivityListener, Context paramContext, BookmarkManager paramBookmarkManager)
  {
    this.a = paramHandler;
    this.b = paramOrcaForegroundActivityListener;
    this.c = paramContext;
    this.d = paramBookmarkManager;
  }

  public void a(int paramInt)
  {
    NotificationsGet.b(this.c, paramInt);
    if (this.b.a() == null);
    while (true)
    {
      return;
      this.a.post(new FbandroidPushHandler.3(this));
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    NotificationsGet.a(this.c, paramInt2);
    Activity localActivity = this.b.a();
    if (localActivity == null);
    while (true)
    {
      return;
      this.d.a(217974574879787L, paramInt1);
      this.a.post(new FbandroidPushHandler.1(this, localActivity));
    }
  }

  public void b(int paramInt1, int paramInt2)
  {
    NotificationsGet.a(this.c, paramInt1, paramInt2);
    if (this.b.a() == null);
    while (true)
    {
      return;
      this.a.post(new FbandroidPushHandler.2(this, paramInt2));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.FbandroidPushHandler
 * JD-Core Version:    0.6.0
 */