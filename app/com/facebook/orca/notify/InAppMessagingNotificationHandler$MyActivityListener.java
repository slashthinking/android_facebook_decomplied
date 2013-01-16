package com.facebook.orca.notify;

import android.app.Activity;
import android.view.View;
import com.facebook.orca.activity.AbstractFbActivityListener;

public class InAppMessagingNotificationHandler$MyActivityListener extends AbstractFbActivityListener
{
  public InAppMessagingNotificationHandler$MyActivityListener(InAppMessagingNotificationHandler paramInAppMessagingNotificationHandler)
  {
  }

  public void b(Activity paramActivity)
  {
    InAppMessagingNotificationHandler.a(this.a, paramActivity);
  }

  public void c(Activity paramActivity)
  {
    InAppMessagingNotificationHandler.a(this.a, null);
    if (InAppMessagingNotificationHandler.d(this.a) != null)
    {
      InAppNotificationView localInAppNotificationView = InAppMessagingNotificationHandler.d(this.a);
      InAppMessagingNotificationHandler.a(this.a, null);
      localInAppNotificationView.postDelayed(new InAppMessagingNotificationHandler.MyActivityListener.1(this, localInAppNotificationView), 1000L);
    }
    InAppMessagingNotificationHandler.c(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.notify.InAppMessagingNotificationHandler.MyActivityListener
 * JD-Core Version:    0.6.0
 */