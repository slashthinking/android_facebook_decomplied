package android.support.v4.app;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

class NotificationCompat$NotificationCompatImplJellybean
  implements NotificationCompat.NotificationCompatImpl
{
  public Notification a(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompatJellybean localNotificationCompatJellybean = new NotificationCompatJellybean(paramBuilder.a, paramBuilder.r, paramBuilder.b, paramBuilder.c, paramBuilder.h, paramBuilder.f, paramBuilder.i, paramBuilder.d, paramBuilder.e, paramBuilder.g, paramBuilder.n, paramBuilder.o, paramBuilder.p, paramBuilder.k, paramBuilder.j, paramBuilder.m);
    Iterator localIterator = paramBuilder.q.iterator();
    while (localIterator.hasNext())
    {
      NotificationCompat.Action localAction = (NotificationCompat.Action)localIterator.next();
      localNotificationCompatJellybean.a(localAction.a, localAction.b, localAction.c);
    }
    if (paramBuilder.l != null)
    {
      if (!(paramBuilder.l instanceof NotificationCompat.BigTextStyle))
        break label177;
      NotificationCompat.BigTextStyle localBigTextStyle = (NotificationCompat.BigTextStyle)paramBuilder.l;
      localNotificationCompatJellybean.a(localBigTextStyle.b, localBigTextStyle.d, localBigTextStyle.c, localBigTextStyle.a);
    }
    while (true)
    {
      return localNotificationCompatJellybean.a();
      label177: if ((paramBuilder.l instanceof NotificationCompat.InboxStyle))
      {
        NotificationCompat.InboxStyle localInboxStyle = (NotificationCompat.InboxStyle)paramBuilder.l;
        localNotificationCompatJellybean.a(localInboxStyle.b, localInboxStyle.d, localInboxStyle.c, localInboxStyle.a);
        continue;
      }
      if (!(paramBuilder.l instanceof NotificationCompat.BigPictureStyle))
        continue;
      NotificationCompat.BigPictureStyle localBigPictureStyle = (NotificationCompat.BigPictureStyle)paramBuilder.l;
      localNotificationCompatJellybean.a(localBigPictureStyle.b, localBigPictureStyle.d, localBigPictureStyle.c, localBigPictureStyle.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.NotificationCompatImplJellybean
 * JD-Core Version:    0.6.0
 */