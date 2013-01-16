package com.facebook.orca.fbwebrtc;

import android.app.NotificationManager;
import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.inject.AbstractProvider;

class WebrtcModule$WebrtcNotificationManagerProvider extends AbstractProvider<WebrtcNotificationManager>
{
  private WebrtcModule$WebrtcNotificationManagerProvider(WebrtcModule paramWebrtcModule)
  {
  }

  public WebrtcNotificationManager a()
  {
    return new WebrtcNotificationManager((Context)b(Context.class, FromApplication.class), (NotificationManager)b(NotificationManager.class, FromApplication.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcModule.WebrtcNotificationManagerProvider
 * JD-Core Version:    0.6.0
 */