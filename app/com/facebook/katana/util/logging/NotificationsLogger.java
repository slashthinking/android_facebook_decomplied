package com.facebook.katana.util.logging;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.InteractionLogger;

public class NotificationsLogger
{
  public static Intent a(Context paramContext, NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    return new Intent(paramContext, NotificationsLogger.NotificationsLogService.class).putExtra("NOTIF_LOG", paramNotificationLogObject).putExtra("EVENT_TYPE", NotificationsLogger.Event.CLEAR_FROM_TRAY);
  }

  public static Intent a(Context paramContext, NotificationsLogger.NotificationLogObject paramNotificationLogObject, Intent paramIntent)
  {
    return new Intent(paramContext, NotificationsLogger.NotificationsLogService.class).putExtra("NOTIF_LOG", paramNotificationLogObject).putExtra("EVENT_TYPE", NotificationsLogger.Event.CLICK_FROM_TRAY).putExtra(NotificationsLogger.NotificationsLogService.a, paramIntent.addFlags(268435456));
  }

  public static void a(Context paramContext, NotificationsLogger.NotificationLogObject paramNotificationLogObject, NotificationsLogger.Event paramEvent)
  {
    if (paramNotificationLogObject == null);
    while (true)
    {
      return;
      new InteractionLogger(paramContext).a(new NotificationsLogger.PushNotificationEvent(paramEvent, paramNotificationLogObject));
    }
  }

  public static void b(Context paramContext, NotificationsLogger.NotificationLogObject paramNotificationLogObject, NotificationsLogger.Event paramEvent)
  {
    if (paramNotificationLogObject == null);
    while (true)
    {
      return;
      new InteractionLogger(paramContext).a(new NotificationsLogger.JewelNotificationEvent(paramEvent, paramNotificationLogObject));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger
 * JD-Core Version:    0.6.0
 */