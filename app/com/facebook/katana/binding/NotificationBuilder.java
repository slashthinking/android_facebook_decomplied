package com.facebook.katana.binding;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.base.BuildConstants;

public class NotificationBuilder
{
  private boolean a = true;
  private boolean b = true;
  private boolean c = true;
  private String d = null;
  private NotificationCompat.Builder e;

  public NotificationBuilder(Context paramContext)
  {
    this.e = new NotificationCompat.Builder(paramContext);
    this.e.b(true);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    this.a = localSharedPreferences.getBoolean("use_led", true);
    a(localSharedPreferences.getString("ringtone", null));
    this.b = localSharedPreferences.getBoolean("vibrate", true);
  }

  public NotificationBuilder a()
  {
    this.a = false;
    return this;
  }

  public NotificationBuilder a(int paramInt)
  {
    this.e.a(paramInt);
    return this;
  }

  public NotificationBuilder a(long paramLong)
  {
    this.e.a(paramLong);
    return this;
  }

  public NotificationBuilder a(PendingIntent paramPendingIntent)
  {
    this.e.a(paramPendingIntent);
    return this;
  }

  public NotificationBuilder a(CharSequence paramCharSequence)
  {
    this.e.b(paramCharSequence);
    return this;
  }

  public NotificationBuilder a(String paramString)
  {
    this.d = paramString;
    return this;
  }

  public NotificationBuilder b()
  {
    this.b = false;
    return this;
  }

  public NotificationBuilder b(PendingIntent paramPendingIntent)
  {
    this.e.b(paramPendingIntent);
    return this;
  }

  public NotificationBuilder b(CharSequence paramCharSequence)
  {
    this.e.c(paramCharSequence);
    return this;
  }

  public NotificationBuilder c()
  {
    this.c = false;
    return this;
  }

  public NotificationBuilder c(CharSequence paramCharSequence)
  {
    if (BuildConstants.a())
      paramCharSequence = String.format("%s - beta", new Object[] { paramCharSequence });
    this.e.a(paramCharSequence);
    return this;
  }

  public Notification d()
  {
    if (this.a)
      this.e.a(-16776961, 500, 2000);
    if ((this.c) && (this.d != null) && (this.d.length() > 0))
      this.e.a(Uri.parse(this.d), 2);
    if (this.b)
      this.e.b(2);
    return this.e.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.NotificationBuilder
 * JD-Core Version:    0.6.0
 */