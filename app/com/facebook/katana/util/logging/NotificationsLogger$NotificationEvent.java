package com.facebook.katana.util.logging;

import com.facebook.analytics.HoneyClientEvent;

abstract class NotificationsLogger$NotificationEvent extends HoneyClientEvent
{
  public NotificationsLogger$NotificationEvent(NotificationsLogger.Event paramEvent, NotificationsLogger.NotificationLogObject paramNotificationLogObject, String paramString)
  {
    super(paramEvent.toString());
    f(paramNotificationLogObject.f());
    e(paramNotificationLogObject.g());
    d(paramString);
    a("id", paramNotificationLogObject.e());
    b("l", paramNotificationLogObject.h());
    a(paramNotificationLogObject);
  }

  protected abstract void a(NotificationsLogger.NotificationLogObject paramNotificationLogObject);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger.NotificationEvent
 * JD-Core Version:    0.6.0
 */