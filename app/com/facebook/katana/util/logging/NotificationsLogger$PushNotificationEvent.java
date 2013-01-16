package com.facebook.katana.util.logging;

class NotificationsLogger$PushNotificationEvent extends NotificationsLogger.NotificationEvent
{
  public NotificationsLogger$PushNotificationEvent(NotificationsLogger.Event paramEvent, NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    super(paramEvent, paramNotificationLogObject, FB4A_AnalyticEntities.Modules.d);
  }

  protected void a(NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    b("ct", paramNotificationLogObject.b());
    a("ci", paramNotificationLogObject.c());
    b("n", paramNotificationLogObject.a());
    a("u", paramNotificationLogObject.d());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger.PushNotificationEvent
 * JD-Core Version:    0.6.0
 */