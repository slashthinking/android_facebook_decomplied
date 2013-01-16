package android.support.v4.app;

import android.os.Build.VERSION;

public class NotificationCompat
{
  private static final NotificationCompat.NotificationCompatImpl a;

  static
  {
    if (Build.VERSION.SDK_INT >= 16)
      a = new NotificationCompat.NotificationCompatImplJellybean();
    while (true)
    {
      return;
      if (Build.VERSION.SDK_INT >= 14)
      {
        a = new NotificationCompat.NotificationCompatImplIceCreamSandwich();
        continue;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        a = new NotificationCompat.NotificationCompatImplHoneycomb();
        continue;
      }
      a = new NotificationCompat.NotificationCompatImplBase();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.6.0
 */