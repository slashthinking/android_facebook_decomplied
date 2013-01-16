package com.facebook.katana.model;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;

class FacebookPushNotification$FetchNotificationListener extends AppSessionListener
{
  private final Context b;
  private final CharSequence c;
  private final int d;
  private final NotificationsLogger.NotificationLogObject e;
  private final String f;

  public FacebookPushNotification$FetchNotificationListener(FacebookPushNotification paramFacebookPushNotification, Context paramContext, CharSequence paramCharSequence, int paramInt, NotificationsLogger.NotificationLogObject paramNotificationLogObject, String paramString)
  {
    this.b = paramContext;
    this.c = paramCharSequence;
    this.d = paramInt;
    this.e = paramNotificationLogObject;
    this.f = paramString;
  }

  public void i(AppSession paramAppSession, String paramString1, int paramInt, String paramString2, Exception paramException)
  {
    if ((this.f != null) && (this.f.equals(paramString1)))
    {
      Intent localIntent = IntentUriHandler.a(this.b, "fb://notifications");
      FacebookPushNotification.a(this.a, localIntent, this.b, this.c, this.d, this.e);
      paramAppSession.b(this);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPushNotification.FetchNotificationListener
 * JD-Core Version:    0.6.0
 */