package com.facebook.katana.notification.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.binding.NotificationBuilder;
import com.facebook.katana.binding.SystemTrayNotificationManager;
import com.facebook.katana.model.FacebookPushNotification.NotificationType;
import com.facebook.katana.util.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.notifications.intent.INotificationRenderer;
import com.facebook.orca.annotations.FromApplication;
import com.google.common.base.Preconditions;

public class DefaultNotificationRenderer
  implements INotificationRenderer
{
  Context a;

  public DefaultNotificationRenderer(@FromApplication Context paramContext)
  {
    this.a = ((Context)Preconditions.checkNotNull(paramContext));
  }

  public void a(String paramString1, String paramString2, Long paramLong)
  {
    Intent localIntent = IntentUriHandler.a(this.a, paramString1);
    if (localIntent == null);
    while (true)
    {
      return;
      NotificationBuilder localNotificationBuilder = new NotificationBuilder(this.a).a(paramString2).b(paramString2).c(this.a.getResources().getString(2131362037)).a(2130838949).a(System.currentTimeMillis());
      NotificationsLogger.NotificationLogObject localNotificationLogObject = new NotificationsLogger.NotificationLogObject().a(FacebookPushNotification.NotificationType.STALE_CLIENT_NOTIFICATION).a(paramLong.longValue());
      SystemTrayNotificationManager.a(this.a, 31, localNotificationBuilder, localIntent, localNotificationLogObject);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.notification.impl.DefaultNotificationRenderer
 * JD-Core Version:    0.6.0
 */