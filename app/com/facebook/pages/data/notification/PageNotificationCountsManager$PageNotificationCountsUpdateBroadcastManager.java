package com.facebook.pages.data.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.orca.inject.FbInjector;

public class PageNotificationCountsManager$PageNotificationCountsUpdateBroadcastManager extends BroadcastReceiver
{
  private PageNotificationCountsManager a;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a == null)
      this.a = ((PageNotificationCountsManager)FbInjector.a(paramContext).a(PageNotificationCountsManager.class));
    this.a.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.notification.PageNotificationCountsManager.PageNotificationCountsUpdateBroadcastManager
 * JD-Core Version:    0.6.0
 */