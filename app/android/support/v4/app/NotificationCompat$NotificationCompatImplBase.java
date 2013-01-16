package android.support.v4.app;

import android.app.Notification;

class NotificationCompat$NotificationCompatImplBase
  implements NotificationCompat.NotificationCompatImpl
{
  public Notification a(NotificationCompat.Builder paramBuilder)
  {
    Notification localNotification = paramBuilder.r;
    localNotification.setLatestEventInfo(paramBuilder.a, paramBuilder.b, paramBuilder.c, paramBuilder.d);
    if (paramBuilder.j > 0)
      localNotification.flags = (0x80 | localNotification.flags);
    return localNotification;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplBase
 * JD-Core Version:    0.6.0
 */