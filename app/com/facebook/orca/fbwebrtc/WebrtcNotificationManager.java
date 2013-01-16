package com.facebook.orca.fbwebrtc;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;

public class WebrtcNotificationManager
{
  private static final Class<?> a = WebrtcNotificationManager.class;
  private final Context b;
  private final NotificationManager c;

  public WebrtcNotificationManager(Context paramContext, NotificationManager paramNotificationManager)
  {
    this.b = paramContext;
    this.c = paramNotificationManager;
  }

  public void a()
  {
    this.c.cancel(10005);
  }

  public void a(long paramLong, String paramString)
  {
    Intent localIntent = new Intent(this.b, WebrtcIncallActivity.class);
    localIntent.setAction("com.facebook.orca.fbwebrtc.intent.action.SHOW_UI");
    localIntent.putExtra("CONTACT_ID", paramLong);
    PendingIntent localPendingIntent = PendingIntent.getActivity(this.b, 0, localIntent, 268435456);
    Notification localNotification = new NotificationCompat.Builder(this.b).a(2130838336).a(paramString).b(this.b.getString(2131362729)).a(true).a(localPendingIntent).a();
    this.c.notify(10005, localNotification);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.fbwebrtc.WebrtcNotificationManager
 * JD-Core Version:    0.6.0
 */