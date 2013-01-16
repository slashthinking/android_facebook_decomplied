package com.facebook.katana.util.logging;

class NotificationsLogger$JewelNotificationEvent extends NotificationsLogger.NotificationEvent
{
  public NotificationsLogger$JewelNotificationEvent(NotificationsLogger.Event paramEvent, NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    super(paramEvent, paramNotificationLogObject, FB4A_AnalyticEntities.Modules.c);
  }

  protected void a(NotificationsLogger.NotificationLogObject paramNotificationLogObject)
  {
    a("hn", paramNotificationLogObject.i());
    a("iu", paramNotificationLogObject.j());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.logging.NotificationsLogger.JewelNotificationEvent
 * JD-Core Version:    0.6.0
 */